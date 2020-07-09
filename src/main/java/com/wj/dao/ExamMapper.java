package com.wj.dao;

import com.wj.pojo.Exam.ExamHistory;
import com.wj.pojo.Exam.ExamInformation;
import com.wj.pojo.Exam.PaperChoice;
import com.wj.pojo.Exam.PaperJudge;
import com.wj.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamMapper {
    /* 管理员查询考试信息 */
    List<ExamInformation> allExam();
    /* 管理员创建考试信息 */
    void adminExamAdd(ExamInformation examInformation);
    /* 选择题生成 */
    List<PaperChoice> RandChoice(@Param("choicenum") long choicenum, @Param("chaptertwo") String chaptertwo, @Param("difficulty") int difficulty);
    /* 判断题生成 */
    List<PaperJudge> RandJudge(@Param("judgenum") long judgenum,
                               @Param("chaptertwo") String chaptertwo, @Param("difficulty") int difficulty);
    /* 选择题试卷生成 */
    void insertRandChoice(List<PaperChoice> paperChoices);
    /* 判断题试卷生成 */
    void insertRandJudge(List<PaperJudge> paperJudges);
    /* 获得试卷ID */
    ExamInformation findExamId(ExamInformation examInformation);

    /* 通过id获取试卷基本信息 */
    ExamInformation findByExamId(int examid);
    /* 通过examId获取选择题试卷 */
    List<PaperChoice> findPaperChoiceByExamId(int examid);
    /* 通过examId获取判断题试卷 */
    List<PaperJudge> findPaperJudgeByExamId(int examid);
    /* 通过id查找学生考试 */
    List<ExamHistory> ByStudentId(int id);
    /* 通过试卷id查询所有考试信息 */
    List<ExamInformation> AlreadExam(List<Long> longList);
    /* 通过试卷id获取考试记录信息 */
    List<ExamHistory> ByExamId(int examid);

}
