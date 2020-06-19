package com.wj.service;

import com.wj.pojo.BasicInfo.Depart;
import com.wj.pojo.BasicInfo.Semester;
import com.wj.pojo.BasicInfo.Sit;

import java.util.List;

public interface BasicInfoService {
    /* 查询所有院系信息 */
    List<Depart> selAllDepart();

    /* 添加院系 */
    void insDepart(Depart depart);
    /* 修改院系名称 */
    void updDepart(Depart depart);

    /* 删除院系 */
    void delDepart(long id);

    /* 查询所有职称信息*/
    List<Sit> selAllSit();

    /* 添加职称*/
    void insSit(Sit sit);

    /* 修改职称 */
    void updSit(Sit sit);

    /* 删除职称 */
    void delSit(long id);

    /* 查询所有学期信息 */
    List<Semester> findAllSemester();

    /* 添加学期信息 */
    void insSemester(Semester semester);

    /* 修改学期 */
    void updSemester(Semester semester);

}
