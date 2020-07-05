package com.wj.service;

import com.wj.pojo.Tk.Judge;

import java.util.List;

public interface JudgeService {
    /* 查询所有判断题 */
    List<Judge> findAllJudge();
    /* 添加判断题 */
    void addJudge(Judge judge);
}
