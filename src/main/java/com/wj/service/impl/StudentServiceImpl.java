package com.wj.service.impl;

import com.wj.dao.StudentMapper;
import com.wj.pojo.Student;
import com.wj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    /* 查询学生信息 */
    @Override
    public Student login(String username) {
        return studentMapper.login(username);
    }
    /* 查询学生信息 */
    @Override
    public Student byNum(String num) {
        return studentMapper.byNum(num);
    }
    /* 通过学生id查询所有学生信息 */
    @Override
    public List<Student> AllStudent(List<Long> longList) {
        return studentMapper.AllStudent(longList);
    }
}
