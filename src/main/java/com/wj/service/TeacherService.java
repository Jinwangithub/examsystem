package com.wj.service;

import com.wj.pojo.Teacher;

public interface TeacherService {
    /* 教师登录验证 */
    Teacher login(String username);
}
