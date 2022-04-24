package xyz.xianlin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * JDBC配置
 */
public class JdbcConfig {
    @Bean
    public DataSource dataSource() {
        // 配置Druid数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver"); // 设置驱动
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1?useSSL=false"); // 设置连接URL
        dataSource.setUsername("root"); // 设置用户名
        dataSource.setPassword("1234"); // 设置密码
        return dataSource; // 返回数据源
    }
}
