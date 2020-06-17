package com.wj.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wj.pojo.Teacher;
import com.wj.pojo.User;
import com.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        }else{//用户名错误
            model.addAttribute("message","用户名或密码错误");
            return "page/loginInfo";
        }
    }

    /**
     * 返回登录界面
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

    /**
     * 管理员退出登录：清除session
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "logout.do")
    public String logout(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        session.removeAttribute("usersession");
        model.addAttribute("message","退出成功");
        return "page/loginInfo";
    }

    /**
     * 查询所有教师信息
     * @param model
     * @return
     */
    @RequestMapping(value = "findallteacher.do")
    public String findallteacher(Model model){
        List<Teacher> allTeacher = userServiceImpl.findAllTeacher();
        model.addAttribute("teachers",allTeacher);
        return "page/admin/teacher";
    }

    /**
     * 创建教师信息
     * @param teacher
     * @param model
     * @return
     */
    @RequestMapping(value = "save.do")
    public String saveTeacher(Teacher teacher,Model model) {
        int index = userServiceImpl.createTeacher(teacher);
        if (index == 1) {
            return "redirect:findallteacher.do";
        } else {
            model.addAttribute("message","创建失败，请重新创建");
            return "page/admin/messageInfo";
        }
    }

    /**
     * 删除教师信息
     * @param id
     * @return
     */
    @RequestMapping(value = "delete.do")
    public String delTeacher(int id){
        try {
            userServiceImpl.delTeacher(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findallteacher.do";
    }

    /**
     * 修改教师信息（先进行教师信息查询）
     * @param teacher
     * @return
     */
    @RequestMapping(value = "findById.do")
    @ResponseBody
    public Teacher findTeaById(@RequestBody Teacher teacher){
        Teacher teacher_info = userServiceImpl.selTeacherById(teacher.getId());
        if(teacher_info!=null){
            return teacher_info;
        }
        return null;
    }

    /**
     * 更新教师信息
     * @param teacher
     * @param model
     * @return
     */
    @RequestMapping(value = "update.do")
    public String updateTeacher(Teacher teacher,Model model){
        try {
            userServiceImpl.updTeacher(teacher);
            model.addAttribute("message","老师信息更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findallteacher.do";
    }

    /**
     * 批量删除教师信息
     * @param chk_value
     * @return
     */
    @RequestMapping(value = "deletemanyteacher.do")
    public String delManyTeacher(String chk_value){
        userServiceImpl.delManyTeacher(chk_value);
        return "redirect:findallteacher.do";
    }

}





















