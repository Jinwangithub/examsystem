package com.wj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {
    /**
     * 跳转到学生成绩页面
     * @return
     */
    @RequestMapping(value = "findstuscore.do")
    public String findStuScore(){
        return "page/admin/student_score";
    }
}
