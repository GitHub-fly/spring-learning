package com.soft1851.spring.ioc.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/beans.xml"})
public class StudentTest {

    private static Logger logger = LoggerFactory.getLogger(StudentTest.class);

    @Autowired
    private Student studentList;

    @Autowired
    private Student studentSet;

    @Autowired
    private Student studentMap;

    @Test
    public void testStudent() {
        System.out.println(studentList);
        System.out.println(studentSet);
        System.out.println(studentMap);
    }
}
