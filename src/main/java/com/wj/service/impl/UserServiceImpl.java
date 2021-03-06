package com.wj.service.impl;

import com.wj.dao.UserMapper;
import com.wj.pojo.Point1;
import com.wj.pojo.Point2;
import com.wj.pojo.Teacher;
import com.wj.pojo.Tk.Choice;
import com.wj.pojo.User;
import com.wj.service.UserService;
import org.apache.commons.lang3.StringEscapeUtils;
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
    /* 查询知识点一级目录 */
    @Override
    public List<Point1> findPoint1All() {
        return userMapper.findPoint1All();
    }
    /* 增加知识点一级目录 */
    @Override
    public void addPoint1(Point1 point1) {
       userMapper.addPoint1(point1);
    }
    /* 显示知识点一级目录 */
    @Override
    public List<Point1> point1All() {
        return userMapper.Point1All();
    }
    /* 增加二级目录 */
    @Override
    public void addPoint2(Point2 point2) {
        userMapper.addPoint2(point2);
    }

    /* 查询所有选择题 */
    @Override
    public List<Choice> findChoiceAll() {
        List<Choice> choiceAll = userMapper.findChoiceAll();
        //防止转义出错(SQL注入)
        for(int i=0;i<choiceAll.size();i++){
            String s = StringEscapeUtils.escapeHtml4(choiceAll.get(i).getContent());
            choiceAll.get(i).setContent(s);
        }
        return choiceAll;
    }
    /* 添加选择题 */
    @Override
    public void addChioce(Choice choice) {
        userMapper.addChoice(choice);
    }

}
