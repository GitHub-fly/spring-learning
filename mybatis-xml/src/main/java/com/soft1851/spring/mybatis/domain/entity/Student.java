package com.soft1851.spring.mybatis.domain.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author xunmi
 * @ClassName Student
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private Integer studentId;
    private Integer clazzId;
    private String studentName;
    private String hometown;
    private LocalDate birthday;
    /**
     * 学生所属班级
     */
    private Clazz clazz;
    private List<Course> courses;
}
