package com.soft1851.spring.mybatis.domain.entity;

import lombok.*;

import java.sql.Struct;
import java.util.List;

/**
 * @author xunmi
 * @ClassName Course
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    private Integer courseId;
    private String courseName;
    private List<Student> students;
}
