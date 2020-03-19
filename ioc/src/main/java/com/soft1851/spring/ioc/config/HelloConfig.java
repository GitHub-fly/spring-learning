package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xunmi
 * @ClassName HelloConfig
 * @Description TODO
 * @Date 2020/3/19
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.soft1851.spring.ioc")
public class HelloConfig {

    @Bean
    public Hello hello() {
        return new Hello();
    }
}
