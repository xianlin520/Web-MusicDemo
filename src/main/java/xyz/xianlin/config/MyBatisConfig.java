package xyz.xianlin.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

// 配置MyBatis
public class MyBatisConfig {
    @Bean // 返回SqlSessionFactoryBean, 数据库连接池
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource); // 设置数据源, dataSource来自于JDBCConfig, 由Spring自动根据类型自动注入
        sqlSessionFactoryBean.setTypeAliasesPackage("xyz.xianlin.pojo"); // 设置实体类所在包
        return sqlSessionFactoryBean; // 返回SqlSessionFactoryBean
    }
    
    
    @Bean // 配置MapperScannerConfigurer, 扫描Mapper接口
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("xyz.xianlin.dao"); // 设置扫描的Mapper接口所在包
        return mapperScannerConfigurer; // 返回MapperScannerConfigurer
    }
}
