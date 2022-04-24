package xyz.xianlin.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class}; // 指定Spring的配置类
    }
    
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class}; // 指定SpringMVC的配置类
    }
    
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // 指定SpringMVC的映射路径
    }
}
