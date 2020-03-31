package com.soft1851.spring.mybatis.domain.entity;

import lombok.*;

/**
 * @author xunmi
 * @ClassName Teacher
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private Integer clazzId;
    /**
     * 一对一映射关系
     */
    private Clazz clazz;
}
