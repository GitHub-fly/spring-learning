package com.soft1851.spring.ioc.entity;

import lombok.*;

/**
 * @author xunmi
 * @ClassName Phone
 * @Description TODO
 * @Date 2020/3/12
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class Phone {
    private String brand;
    private Double price;
}
