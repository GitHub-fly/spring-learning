package com.soft1851.spring.mybatis.domain.vo;

import lombok.*;

/**
 * @author xunmi
 * @ClassName MatterVo
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatterVo {
    private String teacherName;
    private String clazzName;
    private String studentName;
    private String hometown;
    private String birthday;
}
