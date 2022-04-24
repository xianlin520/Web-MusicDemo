package xyz.xianlin.service;

import xyz.xianlin.pojo.UserData;

public interface UserService {
    /**
     * 根据QQ号查询用户信息- 用于核实此QQ号是否已经注册
     *
     * @param userQQ 用户QQ号
     * @return 用户信息对象
     */
    UserData selectByUserQQ(String userQQ);
    
    /**
     * 根据QQ号和密码查询用户信息- 用于登录
     *
     * @param userQQ       用户QQ号
     * @param userPassword 用户密码
     */
    UserData selectByUserQQAndUserPassword(UserData userData);
    
    /**
     * 插入用户信息 - 用于注册
     *
     * @param userQQ       用户QQ号
     * @param UserName     用户昵称
     * @param userPassword 用户密码
     */
    void insertUser(UserData userData);
    
}
