package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.domain.entity.Forum;

import java.util.List;

/**
 * @author xunmi
 * @ClassName ForumService
 * @Description TODO
 * @Date 2020/3/30
 * @Version 1.0
 **/
public interface ForumService {
    /**
     * 新增实体
     * @param forum
     */
    void insert(Forum forum);

    /**
     * 根据id删除
     * @param id
     */
    void delete(int id);

    /**
     * 修改
     * @param forum
     */
    void update(Forum forum);

    /**
     * 查询所有
     * @return
     */
    List<Forum> selectAll();

    /**
     * 根据id查询Forum
     * @param id
     * @return Forum
     */
    Forum selectForumById(int id);
}
