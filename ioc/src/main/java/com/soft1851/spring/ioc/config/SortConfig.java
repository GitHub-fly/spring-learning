package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.other.Sort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xunmi
 * @ClassName SortConfig
 * @Description TODO
 * @Date 2020/3/19
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.soft1851.spring.ioc")
public class SortConfig {

    @Bean
    public Sort sort() {
        return new Sort();
    }
}
