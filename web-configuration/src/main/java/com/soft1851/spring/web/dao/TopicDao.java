package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @author xunmi
 * @ClassName TopicDao
 * @Description TODO
 * @Date 2020/3/26
 * @Version 1.0
 **/
public interface TopicDao {

    /**
     * 查询所有的话题数据
     * @return List<Topic>
     */
    List<Topic> selectAll();

    /**
     * 批量插入
     * @param topics 专题信息
     * @return int[]
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 新增一个
     * @param topic 专题信息
     * @return int
     */
    int insert(Topic topic);
}
