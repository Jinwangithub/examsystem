package com.wj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wj.pojo.Tk.Judge;
import com.wj.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/tk/")
public class TkController {
    @Autowired
    private JudgeService judgeServiceImpl;
    /**
     * 查询所有选择题信息
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "alljudge.do")
    public String AllJudge(Model model,@RequestParam(defaultValue = "1") int pageNum){
        PageHelper.startPage(pageNum,6);
        List<Judge> allJudge = judgeServiceImpl.findAllJudge();
        PageInfo pageInfo=new PageInfo(allJudge,5);
        model.addAttribute("pageInfo",pageInfo);
        return "page/admin/tk_judge";
    }

    /**
     * 添加判断题
     * @param judge
     * @param model
     * @return
     */
    @RequestMapping(value = "createjudge.do")
    public String addJudge(Judge judge,Model model){
        try {
            judgeServiceImpl.addJudge(judge);
            model.addAttribute("message","添加判断题成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:alljudge.do";
    }
}

















