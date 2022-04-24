package xyz.xianlin.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.xianlin.pojo.UserData;

@Repository // 注解，自动注入
public interface UserDao {
    /**
     * 根据QQ号查询用户信息- 用于核实此QQ号是否已经注册
     *
     * @param userQQ 用户QQ号
     * @return 用户信息对象
     */
    @Select("select * from user_data where userQQ = #{userQQ}")
    UserData selectByUserQQ(String userQQ);
    
    /**
     * 根据QQ号和密码查询用户信息- 用于登录
     *
     * @param userQQ       用户QQ号
     * @param userPassword 用户密码
     */
    @Select("select * from user_data where userQQ = #{userQQ} and userPassword = #{userPassword}")
    UserData selectByUserQQAndUserPassword(UserData userData);
    
    /**
     * 插入用户信息 - 用于注册
     *
     * @param userQQ       用户QQ号
     * @param UserName     用户昵称
     * @param userPassword 用户密码
     */
    @Insert("insert into user_data (userQQ, userName, userPassword) VALUES (#{userQQ}, #{userName}, #{userPassword})")
    boolean insertUser(UserData userData);
    
    
}
