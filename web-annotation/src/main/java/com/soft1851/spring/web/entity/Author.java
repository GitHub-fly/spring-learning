package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xunmi
 * @ClassName Author
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private String avatarUrl;
    private String name;
    private String url;
    private Integer gender;
    private String type;
    private String id;

}
