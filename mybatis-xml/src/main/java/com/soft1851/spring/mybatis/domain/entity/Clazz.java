package com.soft1851.spring.mybatis.domain.entity;

import lombok.*;

import java.util.List;

/**
 * @author xunmi
 * @ClassName Clazz
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Clazz {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;

    /**
     * 管理班级的老师
     */
    private Teacher teacher;
    /**
     * 班级学生集合
     */
    private List<Student> students;
}