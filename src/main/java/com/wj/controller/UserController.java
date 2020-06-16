package com.wj.controller;

import com.wj.pojo.User;
import com.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userServiceImpl;

    /**
     * 用户登录验证
     * @param username 用户名
     * @param password 密码
     * @param session  session长期保存用户信息
     * @param model    springmvc控制
     * @return
     */
    @RequestMapping(value = "login.do")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpSession session, Model model){
        User user = userServiceImpl.login(username);
        if(user!=null){
            if(user.getPassword().equals(password)){//验证成功
                session.setAttribute("usersession",user);
                return "page/admin/home";
            }else{//密码错误
                model.addAttribute("message","用户名或密码错误");
                return "page/loginInfo";
            }
        }else{
            model.addAttribute("message","用户名或密码错误");
            return "page/loginInfo";
        }
    }

    /**
     * 用户名或密码错误时，返回登录界面
     * @return
     */
    @RequestMapping(value = "index.do")
    public String relogin(){
        return "index";
    }

    /**
     * 跳转到修改密码界面，并且获取user.id
     * @param username
     * @param model
     * @return
     */
    @RequestMapping(value = "uppass.do")
    public String uppass(@RequestParam("username") String username,Model model){
        User user = userServiceImpl.login(username);
        model.addAttribute("user",user);
        return "page/admin/uppassword";
    }


    /**
     * 修改密码
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "newpass.do")
    public String newpass(User user, Model model){
        userServiceImpl.updpass(user);
        model.addAttribute("message","密码修改成功");
        return "page/loginInfo";
    }


}





















