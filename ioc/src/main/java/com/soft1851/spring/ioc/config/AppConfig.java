package com.soft1851.spring.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.print.Book;

/**
 * @author xunmi
 * @ClassName AppConfig
 * @Description TODO
 * @Date 2020/3/17
 * @Version 1.0
 **/
@Configuration
public class AppConfig {
    @Bean
    public Book book() {
        return new Book();
    }
}
