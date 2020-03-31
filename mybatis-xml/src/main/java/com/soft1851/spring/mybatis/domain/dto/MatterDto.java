package com.soft1851.spring.mybatis.domain.dto;

import com.soft1851.spring.mybatis.domain.entity.Student;
import lombok.*;

/**
 * @author xunmi
 * @ClassName MatterDto
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatterDto {
    private String teacherName;
    private String clazzName;
    private String studentName;
    private Student student;
}
