package com.soft1851.spring.ioc.entity;

import com.alibaba.druid.sql.visitor.functions.Char;
import lombok.*;

import java.sql.Timestamp;

/**
 * @author xunmi
 * @ClassName Post
 * @Description TODO
 * @Date 2020/3/17
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {

    private Integer postId;
    private Integer forumId;
    private String title;
    private String content;
    private Char[] thumbnail;
    private Timestamp postTime;

}
