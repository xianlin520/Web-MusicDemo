package xyz.xianlin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 表示该类是一个配置类
@ComponentScan(basePackages = {"xyz.xianlin.service", "xyz.xianlin.dao"})// 表示扫描的包
@Import({MyBatisConfig.class, JdbcConfig.class}) // 表示导入其他配置类
public class SpringConfig {

}
