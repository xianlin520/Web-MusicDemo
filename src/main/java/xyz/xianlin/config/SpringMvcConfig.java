package xyz.xianlin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration// 标注为配置类
@ComponentScan({"xyz.xianlin.controller"}) // 扫描控制器
@EnableWebMvc // 启用Spring MVC
@EnableAspectJAutoProxy // 启用Spring AOP
public class SpringMvcConfig {

}
