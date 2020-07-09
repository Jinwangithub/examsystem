package com.wj.dao;

import com.wj.pojo.Student;

import java.util.List;

public interface StudentMapper {
    /* 查询学生信息 */
    Student login(String username);
    /* 查询学生信息 */
    Student byNum(String num);
    /* 通过学生id查询所有学生信息 */
    List<Student> AllStudent(List<Long> longList);

}
