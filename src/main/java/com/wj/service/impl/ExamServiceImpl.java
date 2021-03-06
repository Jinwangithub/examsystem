package com.wj.service.impl;

import com.wj.dao.ExamMapper;
import com.wj.pojo.Exam.ExamHistory;
import com.wj.pojo.Exam.ExamInformation;
import com.wj.pojo.Exam.PaperChoice;
import com.wj.pojo.Exam.PaperJudge;
import com.wj.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;
    /* 管理员查询考试信息 */
    @Override
    public List<ExamInformation> addExam() {
        return examMapper.allExam();
    }
    /* 管理员创建考试信息 */
    @Override
    public void adminExamAdd(ExamInformation examInformation) {
        examMapper.adminExamAdd(examInformation);
    }
    /* 生成选择题 */
    @Override
    public List<PaperChoice> RandChoice(long choicenum, String chaptertwo, int difficulty) {
        return examMapper.RandChoice(choicenum, chaptertwo, difficulty);
    }
    /* 生成判断题 */
    @Override
    public List<PaperJudge> RandJudge(long judgenum, String chaptertwo, int difficulty) {
        return examMapper.RandJudge(judgenum, chaptertwo, difficulty);
    }
    /* 选择题试卷生成 */
    @Override
    public void insertRandChoice(List<PaperChoice> paperChoices) {
        examMapper.insertRandChoice(paperChoices);
    }
    /* 判断题试卷生成 */
    @Override
    public void insertRandJudge(List<PaperJudge> paperJudges) {
        examMapper.insertRandJudge(paperJudges);
    }
    /* 获得试卷id */
    @Override
    public ExamInformation findExamId(ExamInformation examInformation) {
        return examMapper.findExamId(examInformation);
    }
    /* 通过id获取试卷基本信息 */
    @Override
    public ExamInformation findByExamId(int id) {
        return examMapper.findByExamId(id);
    }
    /* 通过examId获取选择题试卷 */
    @Override
    public List<PaperChoice> findPaperChoiceByExamId(int examid) {
        return examMapper.findPaperChoiceByExamId(examid);
    }
    /* 通过examId获取判断题试卷 */
    @Override
    public List<PaperJudge> findPaperJudgeByExamId(int examid) {
        return examMapper.findPaperJudgeByExamId(examid);
    }
    /* 通过学生id查询学生考试 */
    @Override
    public List<ExamHistory> byStudentId(int id) {
        return examMapper.ByStudentId(id);
    }
    /* 通过试卷id查询所有考试信息 */
    @Override
    public List<ExamInformation> AlreadExam(List<Long> longList) {
        return examMapper.AlreadExam(longList);
    }
    /* 通过试卷id获取考试记录信息 */
    @Override
    public List<ExamHistory> ByExamId(int examid) {
        return examMapper.ByExamId(examid);
    }
}
