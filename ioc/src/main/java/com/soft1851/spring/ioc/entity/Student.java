package com.soft1851.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xunmi
 * @ClassName Student
 * @Description TODO
 * @Date 2020/3/12
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Student {
    private Integer id;
    private String name;
    private List<Phone> phones;
    private Set<String> hobby;
    private Map<Long, String> mother;

}
