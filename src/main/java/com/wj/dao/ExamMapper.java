package com.wj.dao;

import com.wj.pojo.Exam.ExamInformation;
import com.wj.pojo.Exam.PaperChoice;
import com.wj.pojo.Exam.PaperJudge;
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

}
