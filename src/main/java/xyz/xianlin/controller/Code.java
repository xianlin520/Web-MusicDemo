package xyz.xianlin.controller;


public class Code {
    /**
     * 查询头: 300
     * 注册头: 400
     * 登录头: 200
     * <p>
     * 成功尾: 1
     * 失败尾: 0
     * <p>
     * 系统异常状态码: 50010
     * 业务异常状态码: 50020
     * 未知异常状态码: 50050
     */
    
    
    // 查询用户信息状态码, 200表信息头表示查询操作, 30011表示查询成功, 30010表示查询失败
    public static final Integer GET_OK = 30011;
    public static final Integer GET_ERR = 30010;
    // 登录状态码, 200表示登录操作, 30021表示登录成功, 30020表示登录失败
    public static final Integer POST_OK = 20051;
    public static final Integer POST_ERR = 20050;
    // 注册状态码, 400表示注册操作, 40031表示注册成功, 40030表示注册失败
    public static final Integer PUT_OK = 40071;
    public static final Integer PUT_ERR = 40070;
    
    // 异常状态码, 50010表示系统异常, 50020表示业务异常, 未知异常状态码: 50050
    public static final Integer SYSTEM_ERR = 50010;
    public static final Integer BUSINESS_ERR = 50020;
    public static final Integer SYSTEM_UNKEOW_ERR = 50050;
    
    
}
