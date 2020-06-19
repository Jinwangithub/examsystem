package com.wj.controller;

import com.wj.pojo.Teacher;
import com.wj.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacher/")
public class TeacherController {
    @Autowired
    private TeacherService teacherServiceImpl;

    /**
     * 教师登录
     * @param username
     * @param password
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "login.do")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpSession session, Model model){
        Teacher teacher = teacherServiceImpl.login(username);
        if(teacher!=null){
            if(teacher.getPassword().equals(password)){
                session.setAttribute("teachersession",teacher);
                return "page/teacher/home";
            }else{
                model.addAttribute("message","用户名或密码错误");
                return "page/loginInfo";
            }
        }else{
            model.addAttribute("message","用户名或密码错误");
            return "page/loginInfo";
        }
    }
}
