package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author xunmi
 * @ClassName Test
 * @Description TODO
 * @Date 2020/3/26
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        // 生成基于注解配置的应用上下文对象
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();
        acac.scan("com.soft1851.spring.web");
        acac.refresh();
        JdbcTemplate jdbcTemplate = (JdbcTemplate) acac.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
    }
}
