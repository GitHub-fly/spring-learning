package com.soft1851.spring.web.entity;

import lombok.*;

/**
 * @author xunmi
 * @ClassName User
 * @Description TODO
 * @Date 2020/3/24
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String userName;
    private String gender;
    private Integer age;
    private String cover;
}
