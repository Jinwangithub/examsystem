package com.wj.controller;

import com.wj.pojo.Exam.*;
import com.wj.pojo.Student;
import com.wj.pojo.Teacher;
import com.wj.service.ExamService;
import com.wj.service.StudentService;
import com.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/exam/")
public class ExamController {
    @Autowired
    private ExamService examServiceImpl;
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private StudentService studentServiceImpl;
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

    /**
     * 学生成绩查询
     * @param name
     * @return
     */
    @RequestMapping(value = "stuscore.do")
    @ResponseBody
    public List<ExamInformation> stuScore(@RequestParam String name){
        List<FindStudentScore> studentScores=new ArrayList<>();
        List<ExamInformation> examInformations=new ArrayList<>();
        //查询学生信息
        Student student=new Student();
        List<Long> longList=new ArrayList<>();//学生试卷id
        if(name.length()<5){
            student = studentServiceImpl.login(name);
        }else{
            student = studentServiceImpl.byNum(name);
        }
        long longId=student.getId();
        List<ExamHistory> examHistories = examServiceImpl.byStudentId((int) longId);//查询学生考试
        if(examHistories.size()==0){
            return examInformations;
        }else{
            for(int i=0;i<examHistories.size();i++){
                longList.add(examHistories.get(i).getExamid());
            }
            examInformations = examServiceImpl.AlreadExam(longList);
            for(int i=0;i<examInformations.size();i++){
                examInformations.get(i).setAllscore((int)examHistories.get(i).getScore());
                examInformations.get(i).setStudentname(student.getUsername());
            }
            return examInformations;
        }
    }

    /**
     * 通过试卷id查询参加过考试的学生信息
     * @param examid
     * @param model
     * @return
     */
    @RequestMapping(value = "allexamstu.do")
    public String allExamStu(@RequestParam int examid,Model model){
        List<ExamHistory> examHistories = examServiceImpl.ByExamId(examid);//获取考试记录信息（studentid）
        List<Long> longList=new ArrayList<>();//学生id
        Map<Long,Long> map=new HashMap<>();//存储学生id以及学生分数
        for(int i=0;i<examHistories.size();i++){
            map.put(examHistories.get(i).getStudentid(),examHistories.get(i).getScore());
            longList.add(examHistories.get(i).getStudentid());
        }
        List<Student> students=new ArrayList<>();//学生
        if(longList.isEmpty()){
            students.add(null);
        }else{
            students = studentServiceImpl.AllStudent(longList);
            for(int i=0;i<examHistories.size();i++){
                students.get(i).setId(map.get(students.get(i).getId()));//id是分数(前端界面要求)
            }
            //比较排序，从小到大分数
            Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                   if(o1.getId()<o2.getId()){
                       return 1;
                   }
                   if(o1.getId()==o2.getId()){
                       return 0;
                   }
                   return -1;
                }
            });

        }
        model.addAttribute("student",students);
        return "page/admin/exam_allstudent";
    }

}




























