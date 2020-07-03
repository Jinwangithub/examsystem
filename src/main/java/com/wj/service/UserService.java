package com.wj.service;

import com.wj.pojo.Point1;
import com.wj.pojo.Teacher;
import com.wj.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    /* 用户登录 */
    User login(String username);

    /* 修改密码 */
    void updpass(User user);

    /*查询所有教师信息*/
    List<Teacher> findAllTeacher();
    /* 创建教师 */
    int createTeacher(Teacher teacher);

    /* 删除教师 */
    void delTeacher(int id);
    /*根据id查询教师信息*/
    Teacher selTeacherById(long id);
    /* 修改教师信息*/
    void updTeacher(Teacher teacher);
    /* 批量删除教师信息*/
    void delManyTeacher(String chk_value);
    /* 知识点一级目录 */
    List<Point1> findPoint1All();
    /* 增加知识点一级目录 */
    void addPoint1(Point1 point1);
    /* 显示一级目录 */
    List<Point1> point1All();
}
