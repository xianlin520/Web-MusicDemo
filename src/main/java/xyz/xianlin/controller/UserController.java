package xyz.xianlin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.xianlin.pojo.UserData;
import xyz.xianlin.service.impl.UserServiceImpl;

@RestController // 标记为控制器
@RequestMapping("/users") // 指定请求路径
public class UserController {
    @Autowired // 注入UserService
    private UserServiceImpl userService;
    
    
    @GetMapping("/{userQQ}") // 指定请求方式为GET, 用于查询用户是否存在
    public Result selectByUserQQ(@PathVariable String userQQ) {
        UserData userData = userService.selectByUserQQ(userQQ);
//        System.out.println(userData);
        return new Result(userData != null ? Code.GET_OK : Code.GET_ERR, userData);
    }
    
    @PostMapping // 指定请求方式为POST, 用于查询用户密码是否正确
    public Result selectByUserQQAndUserPassword(@RequestBody UserData userData) {
        UserData userDataRet = userService.selectByUserQQAndUserPassword(userData);
        return new Result(userDataRet != null ? Code.POST_OK : Code.POST_ERR, userDataRet);
    }
    
    @PutMapping // 指定请求方式为PUT, 用于插入新用户
    public Result insertUser(@RequestBody UserData userData) {
        try {
            userService.insertUser(userData);
            return new Result(Code.PUT_OK, userData, "数据插入成功");
        } catch (Exception e) {
            return new Result(Code.PUT_ERR, userData, "数据插入失败, 数据库内已存在该用户");
        }
        
    }
}
