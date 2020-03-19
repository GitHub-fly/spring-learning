package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Phone;
import com.soft1851.spring.ioc.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * @author xunmi
 * @ClassName StudentConfig
 * @Description TODO
 * @Date 2020/3/19
 * @Version 1.0
 **/
@Configuration
@ComponentScan("com.soft1851.spring.ioc")
public class StudentConfig {

    @Bean
    public Student studentList() {
        List<Phone> list = new ArrayList<>(5);
        list.add(new Phone("OPPO", 666.6));
        list.add(new Phone("iPhone", 888.8));
        Student student = new Student();
        student.setPhones(list);
        return student;
    }

    @Bean
    public Student studentSet() {
        Set<String> stringSet = new HashSet<>(10);
        stringSet.add("打游戏");
        stringSet.add("打游戏");
        stringSet.add("编程");
        stringSet.add("听音乐");
        stringSet.add("跟小伙伴腻在一起");
        stringSet.add("跟小伙伴腻在一起");
        Student student = new Student();
        student.setHobby(stringSet);
        return student;
    }

    @Bean
    public Student studentMap() {
        Map<Long, String> map = new HashMap<>(5);
        map.put(140525199905114413L, "寻寻觅觅");
        Student student = new Student();
        student.setMother(map);
        return student;
    }
}
