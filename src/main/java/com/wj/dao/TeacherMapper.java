package com.wj.dao;

import com.wj.pojo.Teacher;

public interface TeacherMapper {
    /* 教师登录验证 */
    Teacher login(Teacher teacher);
}
