package com.soft1851.spring.ioc.entity;

import lombok.*;

/**
 * @author xunmi
 * @ClassName Book
 * @Description 测试“基于注解的配置类的用法”对象
 * @Date 2020/3/17
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class Book {
    private String name;
    private Double price;
}
