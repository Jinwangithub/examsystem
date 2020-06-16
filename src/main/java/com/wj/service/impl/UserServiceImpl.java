package com.wj.service.impl;

import com.wj.dao.UserMapper;
import com.wj.pojo.User;
import com.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
