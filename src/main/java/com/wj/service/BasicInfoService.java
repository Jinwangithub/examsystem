package com.wj.service;

import com.wj.pojo.BasicInfo.Depart;
import com.wj.pojo.BasicInfo.Sit;

import java.util.List;

public interface BasicInfoService {
    /* 查询所有院系信息 */
    List<Depart> selAllDepart();

    /* 添加院系 */
    void insDepart(Depart depart);

    /* 查询所有职称信息*/
    List<Sit> selAllSit();

    /* 添加职称*/
    void insSit(Sit sit);
}
