package com.soft1851.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xunmi
 * @ClassName Writer
 * @Description TODO
 * @Date 2020/3/17
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Writer {

    private Integer id;
    private String writer;
    private String writerIntroduce;
    private String avatar;

}
