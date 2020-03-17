package com.soft1851.spring.ioc.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beans.xml"})
public class StudentTest {

    private static Logger logger = LoggerFactory.getLogger(StudentTest.class);

    @Test
    public void testStudent() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        // List 属性的测试
        Student student = (Student) ac.getBean("student");
        logger.info(student.toString());
        // Set 属性的测试
        Student studentSet = (Student) ac.getBean("studentSet");
        logger.info(studentSet.toString());
        // Map 属性的测试
        Student studentMap = (Student) ac.getBean("studentMap");
        logger.info(studentMap.toString());
    }
}
