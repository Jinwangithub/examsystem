package com.wj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wj.pojo.Point1;
import com.wj.pojo.Point2;
import com.wj.pojo.Teacher;
import com.wj.pojo.Tk.Choice;
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

    /**
     * 知识点一级目录查询
     * @param model
     * @return
     */
    @RequestMapping(value = "findpoint1.do")
    public String findPoint1(Model model){
        List<Point1> point1All = userServiceImpl.findPoint1All();
        model.addAttribute("point1",point1All);
        return "page/admin/point";
    }

    /**
     * 增加一级目录
     * @param point1
     * @param model
     * @return
     */
    @RequestMapping(value = "addpoint1.do")
    public String addPoint1(Point1 point1,Model model){
        try {
            userServiceImpl.addPoint1(point1);
            model.addAttribute("message","保存章节成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findpoint1.do";
    }

    /**
     * 显示知识点一级目录
     * @param model
     * @return
     */
    @RequestMapping(value = "allpoint1.do")
    @ResponseBody
    public List<Point1> point1All(Model model){
        List<Point1> point1s = userServiceImpl.point1All();
        return point1s;
    }

    /**
     * 增加二级目录
     * @param point2
     * @param model
     * @return
     */
    @RequestMapping(value = "addpoint2.do")
    public String addPoint2(Point2 point2,Model model){
        try {
            userServiceImpl.addPoint2(point2);
            model.addAttribute("message","二级目录添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findpoint1.do";
    }

    /**
     * 选择题查询
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "findallchoice.do")
    public String findAllChoice(Model model,@RequestParam(defaultValue = "1")int pageNum){
        PageHelper.startPage(pageNum,6);
        List<Choice> choiceAll = userServiceImpl.findChoiceAll();
        PageInfo pageInfo=new PageInfo(choiceAll,5);
        model.addAttribute("pageInfo",pageInfo);
        return "page/admin/tk_choice";
    }

    /**
     * 查找所有知识点
     * @param model
     * @return
     */
    @RequestMapping(value = "pointall.do")
    @ResponseBody
    public List<Point1> pointAll(Model model){
        List<Point1> point1All = userServiceImpl.findPoint1All();
        model.addAttribute("point",point1All);
        return point1All;
    }

    /**
     * 添加选择题
     * @param choice
     * @param model
     * @return
     */
    @RequestMapping(value = "addchoice.do")
    public String addChoice(Choice choice,Model model){
        try {
            userServiceImpl.addChioce(choice);
            model.addAttribute("message","选择题添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findallchoice.do";
    }
}





















