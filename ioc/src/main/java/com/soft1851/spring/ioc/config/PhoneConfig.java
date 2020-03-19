package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Phone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xunmi
 * @ClassName PhoneConfig
 * @Description TODO
 * @Date 2020/3/19
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.soft1851.spring.ioc")
public class PhoneConfig {

    @Bean
    public Phone phone() {
        return new Phone();
    }
}
