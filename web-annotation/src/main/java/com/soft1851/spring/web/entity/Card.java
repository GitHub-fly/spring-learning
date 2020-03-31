package com.soft1851.spring.web.entity;

import lombok.*;

/**
 * @author xunmi
 * @ClassName Card
 * @Description TODO
 * @Date 2020/3/24
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Card {
    private String cover;
    private String title;
    private String text;
    private String time;
}
