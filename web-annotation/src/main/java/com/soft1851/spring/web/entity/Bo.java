package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xunmi
 * @ClassName Bo
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bo {
    private String skuId;
    private String type;
    private String description;
    private String title;
    private String url;
    private String cover;
    private Integer bookSize;
    private Integer id;
    private Boolean isOwn;
//    private List<Author> authors;
    private String bookVersion;
    private String score;
    private String cornerText;
    private String name;
}
