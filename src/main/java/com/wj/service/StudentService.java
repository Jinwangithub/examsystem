package com.wj.service;

import com.wj.pojo.Student;

import java.util.List;

public interface StudentService {
    /* 学生信息查询 */
    Student login(String username);
    /* 学生信息查询 */
    Student byNum(String num);
    /* 通过学生id查询所有学生信息 */
    List<Student> AllStudent(List<Long> longList);
}
