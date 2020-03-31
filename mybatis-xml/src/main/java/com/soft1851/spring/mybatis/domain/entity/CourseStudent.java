package com.soft1851.spring.mybatis.domain.entity;

import lombok.*;

/**
 * @author xunmi
 * @ClassName CourseStudent
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseStudent {
    private Integer id;
    private Integer courseId;
    private Integer studentId;
}
