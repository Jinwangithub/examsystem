package com.wj.dao;

import com.wj.pojo.BasicInfo.Depart;
import com.wj.pojo.BasicInfo.Semester;
import com.wj.pojo.BasicInfo.Sit;

import java.util.List;

public interface BasicInfoMapper {
    /* 查询所有院系信息 */
    List<Depart> selAllDepart();

    /* 院系添加 */
    void insDepart(Depart depart);

    /* 院系信息修改 */
    void updateDepart(Depart depart);

    /* 院系删除 */
    void deleteDepart(long id);

    /* 查询所有职称信息 */
    List<Sit> selAllSit();

    /* 添加职称 */
    void insSit(Sit sit);

    /* 修改职称 */
    void updSit(Sit sit);

    /* 删除职称 */
    void delSit(long id);

    /* 查询所有学期信息 */
    List<Semester> findAllSemester();

    /* 添加学期 */
    void insSemester(Semester semester);

    /* 修改学期 */
    void updSemester(Semester semester);
}
