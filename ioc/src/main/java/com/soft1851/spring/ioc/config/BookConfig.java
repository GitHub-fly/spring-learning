package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



/**
 * @author xunmi
 * @ClassName AppConfig
 * @Description TODO
 * @Date 2020/3/17
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.soft1851.spring.ioc")
public class BookConfig {
    @Bean
    public Book book() {
        return new Book();
    }

    @Bean
    public Book bookPlus() {
        return new Book("bookPlus", 66.6);
    }
}
