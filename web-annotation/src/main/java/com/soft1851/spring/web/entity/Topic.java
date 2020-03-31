package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xunmi
 * @ClassName Topic
 * @Description TODO
 * @Date 2020/3/26
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private String id;
    private String topicName;
    private String topicIcon;
    private String description;
    private Integer msgCount;
    private Integer followersCount;
    private Boolean followed;
}
