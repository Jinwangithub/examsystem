package com.wj.service.impl;

import com.wj.dao.UserMapper;
import com.wj.pojo.Teacher;
import com.wj.pojo.User;
import com.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /* 登录验证 */
    @Override
    public User login(String username) {
        User user=new User();
        user.setUsername(username);
        return userMapper.login(user);
    }
    /* 修改密码 */
    @Override
    public void updpass(User user) {
        userMapper.updatepassword(user);
    }
    /* 查询所有教师信息 */
    @Override
    public List<Teacher> findAllTeacher() {
        return userMapper.findAllTeacher();
    }
    /* 创建教师信息 */
    @Override
    public int createTeacher(Teacher teacher) {
        return userMapper.createTeacher(teacher);
    }
    /* 删除教师信息 */
    @Override
    public void delTeacher(int id) {
        userMapper.delTeacher(id);
    }
    /* 更加id查询教师信息*/
    @Override
    public Teacher selTeacherById(long id) {
        return userMapper.selTeacherById(id);
    }
    /* 修改教师信息*/
    @Override
    public void updTeacher(Teacher teacher) {
        userMapper.updateTeacher(teacher);
    }
    /* 批量删除教师信息 */
    @Override
    public void delManyTeacher(String chk_value) {
        String[] string = chk_value.split(",");
        int[] ids=new int[string.length];
        for(int i=0;i<string.length;i++){
            ids[i]=Integer.valueOf(string[i]);
        }
        userMapper.delManyTeacher(ids);
    }

}
