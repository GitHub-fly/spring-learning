package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @author xunmi
 * @ClassName TopicService
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
public interface TopicService {
    /**
     * 查询所有的话题数据
     * @return List<Topic>
     */
    List<Topic> queryAll();

    /**
     * 批量插入
     * @param topics 专题信息
     * @return int[]
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 新增一个
     * @param topic 专题信息
     */
    void addTopic(Topic topic);
}
