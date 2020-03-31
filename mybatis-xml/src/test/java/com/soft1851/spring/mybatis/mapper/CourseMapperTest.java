package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.domain.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class CourseMapperTest {

    @Resource
    private CourseMapper courseMapper;

    @Test
    public void getCourseById() {
        Course course = courseMapper.getCourseById(20001);
        System.out.println(course.getCourseId() + "," + course.getCourseName());
        System.out.println("************************");
        course.getStudents().forEach(student -> {
            System.out.println(student.getStudentId()
            + "," + student.getStudentName()
            + "," + student.getHometown()
            + "," + student.getBirthday());
        });
    }
}