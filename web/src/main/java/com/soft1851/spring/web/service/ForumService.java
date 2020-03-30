package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;

import java.util.List;

/**
 * @author xunmi
 * @ClassName ForumService
 * @Description TODO
 * @Date 2020/3/21
 * @Version 1.0
 **/
public interface ForumService {

    /**
     * 新增 Forum
     * @param forum 帖子
     * @return int
     */
    int insert(Forum forum);

    /**
     * 批量新增 Forum
     * @param forums 帖子集合
     * @return int[]
     */
    int[] batchInsert(List<Forum> forums);

    /**
     * 根据id删除Forum
     * @param forumId id
     * @return int
     */
    int delete(int forumId);

    /**
     * 修改Forum
     * @param forum 帖子
     * @return int
     */
    int update(Forum forum);

    /**
     * 根据id查询Forum
     * @param forumId id
     * @return 帖子
     */
    Forum get(int forumId);

    /**
     * 查询所有论坛信息
     * @return 论坛信息
     */
    List<Forum> selectAll();

}
