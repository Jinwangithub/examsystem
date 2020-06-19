package com.wj.service.impl;

import com.wj.dao.TeacherMapper;
import com.wj.pojo.Teacher;
import com.wj.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    /* 用户登录验证 */
    @Override
    public Teacher login(String username) {
        Teacher teacher=new Teacher();
        teacher.setUsername(username);
        return teacherMapper.login(teacher);
    }
}
