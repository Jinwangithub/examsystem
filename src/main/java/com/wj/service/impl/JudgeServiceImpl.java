package com.wj.service.impl;

import com.wj.dao.JudgeMapper;
import com.wj.pojo.Tk.Judge;
import com.wj.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgeServiceImpl implements JudgeService {
    @Autowired
    private JudgeMapper judgeMapper;
    /* 查询所有判断题 */
    @Override
    public List<Judge> findAllJudge() {
        return judgeMapper.findAllJudge();
    }
    /* 添加判断题 */
    @Override
    public void addJudge(Judge judge) {
        judgeMapper.addJudge(judge);
    }
}
