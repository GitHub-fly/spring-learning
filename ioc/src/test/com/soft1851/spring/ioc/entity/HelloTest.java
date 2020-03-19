package com.soft1851.spring.ioc.entity;

import com.soft1851.spring.ioc.config.HelloConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/beans.xml"})
@ContextConfiguration(classes = {HelloConfig.class})
public class HelloTest {

    @Autowired
    private Hello hello;

    @Test
    public void sayHello() {
        hello.sayHello();
    }
}