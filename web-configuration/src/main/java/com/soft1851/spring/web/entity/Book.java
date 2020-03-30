package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xunmi
 * @ClassName Book
 * @Description TODO
 * @Date 2020/3/24
 * @Version 1.0
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private String author;
    private String cover;
    private String description;

    public Book(Integer id, String title, String cover) {
        this.id = id;
        this.title = title;
        this.cover = cover;
    }
}
