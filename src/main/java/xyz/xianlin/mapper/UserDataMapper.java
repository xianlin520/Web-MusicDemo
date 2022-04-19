package xyz.xianlin.mapper;

import org.apache.ibatis.annotations.Select;
import xyz.xianlin.pojo.UserData;

public interface UserDataMapper {
    /**
     * 查询用户数据
     * @param userQQ 用户QQ
     * @return 用户数据, 如果没有则返回null
     */
    @Select("select * from user_data where userQQ = #{userQQ};")
    UserData selectByUserQQ(String userQQ);
    
    /**
     * 查询用户数据, 登录时使用
     * @param userData 用户数据, 必须包含userQQ和userPassword
     * @return 用户数据, 如果没有则返回null
     */
    @Select("select * from user_data where userQQ = #{userQQ} and userPassword = #{userPassword};")
    UserData selectByUserQQAndUserPassword(UserData userData);
    
    
    /*@Insert("INSERT INTO user_data (userQQ, userName, userPassword)VALUES (#{userQQ}, #{userName}, #{userPassword});")
    void insert(UserData userData);*/
    void insert(UserData userData);
}
