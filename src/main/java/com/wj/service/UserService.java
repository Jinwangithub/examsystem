package com.wj.service;

import com.wj.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    /* 用户登录 */
    User login(String username);

    /* 修改密码 */
    void updpass(User user);
}
