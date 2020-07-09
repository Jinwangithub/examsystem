package com.wj.service;

import com.wj.pojo.Exam.ExamHistory;
import com.wj.pojo.Exam.ExamInformation;
import com.wj.pojo.Exam.PaperChoice;
import com.wj.pojo.Exam.PaperJudge;

import java.util.List;

public interface ExamService {
    /* 管理员查询考试信息 */
    List<ExamInformation> addExam();
    /* 管理员创建考试信息 */
    void adminExamAdd(ExamInformation examInformation);
    /* 生成选择题 */
    List<PaperChoice> RandChoice(long choicenum,String chaptertwo,int difficulty);
    /* 判断题生成 */
    List<PaperJudge> RandJudge(long judgenum,String chaptertwo,int difficulty);
    /* 选择题试卷生成 */
    void insertRandChoice(List<PaperChoice> paperChoices);
    /* 判断题试卷生成 */
    void insertRandJudge(List<PaperJudge> paperJudges);
    /* 获得试卷id */
    ExamInformation findExamId(ExamInformation examInformation);
    /* 通过id获取试卷基本信息 */
    ExamInformation findByExamId(int id);
    /* 通过examId获取选择题试卷 */
    List<PaperChoice> findPaperChoiceByExamId(int examid);
    /* 通过examId获取判断题试卷 */
    List<PaperJudge> findPaperJudgeByExamId(int examid);
    /* 通过学生id查询学生考试 */
    List<ExamHistory> byStudentId(int id);
    /* 通过试卷id查询所有考试信息 */
    List<ExamInformation> AlreadExam(List<Long> longList);
    /* 通过试卷id获取考试记录信息 */
    List<ExamHistory> ByExamId(int examid);
}
