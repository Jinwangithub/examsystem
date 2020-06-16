package com.wj.dao;

import com.wj.pojo.User;

public interface UserMapper {
    /* 数据库登录验证 */
    User login(User user);
    /* 修改管理员密码 */
    User uppass(User user);
    /* 修改密码 */
    void updatepassword(User user);
}
