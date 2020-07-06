package com.wj.controller;

import com.wj.pojo.Exam.ExamInformation;
import com.wj.pojo.Exam.PaperChoice;
import com.wj.pojo.Exam.PaperJudge;
import com.wj.pojo.Teacher;
import com.wj.service.ExamService;
import com.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/exam/")
public class ExamController {
    @Autowired
    private ExamService examServiceImpl;
    @Autowired
    private UserService userServiceImpl;
    /**
     * 管理员查询考试信息
     * @param model
     * @return
     */
    @RequestMapping(value = "allexam.do")
    public String allExam(Model model){
        List<ExamInformation> examInformations = examServiceImpl.addExam();
        model.addAttribute("examInfo",examInformations);
        return "page/admin/exam_info";
    }

    /**
     * 管理员添加考试--查看所有老师信息
     * @param model
     * @return
     */
    @RequestMapping(value = "adminaddexam.do")
    public String adminAddExam(Model model){
        List<Teacher> allTeacher = userServiceImpl.findAllTeacher();
        model.addAttribute("teacher",allTeacher);
        return "page/admin/addexam";
    }

    /**
     * 管理员生成考试试卷
     * @param examInformation
     * @return
     */
    @RequestMapping(value = "adminexamadd.do")
    public String adminExamAdd(ExamInformation examInformation){
        examServiceImpl.adminExamAdd(examInformation);//考试信息创建
        ExamInformation examId = examServiceImpl.findExamId(examInformation);
        examInformation.setId(examId.getId());//获取试卷id
        List<PaperChoice> paperChoices = examServiceImpl.RandChoice((long) examInformation.getChoicenum(),
                examInformation.getChaptertwo(), examInformation.getDifficulty());//选择题生成
        List<PaperJudge> paperJudges = examServiceImpl.RandJudge(examInformation.getJudgenum(),
                examInformation.getChaptertwo(), examInformation.getDifficulty());//判断题生成
        for(int i=0;i<paperChoices.size();i++){
            paperChoices.get(i).setExamid(examInformation.getId());
        }
        examServiceImpl.insertRandChoice(paperChoices);//选择题试卷生成
        for(int i=0;i<paperJudges.size();i++){
            paperJudges.get(i).setExamid(examInformation.getId());
        }
        examServiceImpl.insertRandJudge(paperJudges);//判断题试卷生成
        return "redirect:allexam.do";
    }

    /**
     * 管理员查看考试试卷
     * @param examid
     * @param model
     * @return
     */
    @RequestMapping(value = "admindetail.do")
    public String adminExamDetail(@RequestParam int examid,Model model){
        ExamInformation examInformation = examServiceImpl.findByExamId(examid);//获取试卷基本信息
        List<PaperChoice> paperChoice = examServiceImpl.findPaperChoiceByExamId(examid);//获取选择题试卷
        List<PaperJudge> paperJudge = examServiceImpl.findPaperJudgeByExamId(examid);//获取判断题试卷
        model.addAttribute("examinfo",examInformation);
        model.addAttribute("choice",paperChoice);
        model.addAttribute("judge",paperChoice);
        return "page/admin/exam_detail";
    }

}




























