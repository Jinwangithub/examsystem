package com.wj.dao;

import com.wj.pojo.BasicInfo.Sit;
import com.wj.pojo.Teacher;
import com.wj.pojo.User;

import java.util.List;

public interface UserMapper {
    /* 数据库登录验证 */
    User login(User user);
    /* 修改管理员密码 */
    User uppass(User user);
    /* 修改密码 */
    void updatepassword(User user);
    /* 查询所有老师信息 */
    List<Teacher> findAllTeacher();
    /* 添加教师信息 */
    int createTeacher(Teacher teacher);
    /*删除教师信息*/
    void delTeacher(int id);
    /*通过Id查找教师信息*/
    Teacher selTeacherById(long id);
    /* 更新教师信息 */
    void updateTeacher(Teacher teacher);
    /* 批量删除老师信息*/
    void delManyTeacher(int[] id);
}
