package com.wj.dao;

import com.wj.pojo.Tk.Judge;

import java.util.List;

public interface JudgeMapper {
    /* 查询所有判断题 */
    List<Judge> findAllJudge();
    /* 添加判断题 */
    void addJudge(Judge judge);
}
