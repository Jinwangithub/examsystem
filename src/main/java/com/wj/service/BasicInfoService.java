package com.wj.service;

import com.wj.pojo.BasicInfo.*;
import com.wj.pojo.Student;

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

    /* 查询所有专业 */
    List<Major> selAllMajor(long seid);

    /* 添加专业 */
    void insMajor(Major major);

    /* 修改专业信息 */
    void updMajor(Major major);

    /* 查询班级信息 */
    List<Blass> selByMaid(long maid);

    /* 添加班级 */
    void insClass(Blass blass);

    /* 查询班级内所有学生 */
    List<Student> selByCname(String cname);

    /* 添加学生信息 */
    void insStudent(Student student);

}
