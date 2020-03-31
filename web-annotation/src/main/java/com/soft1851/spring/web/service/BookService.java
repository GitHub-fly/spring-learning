package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Book;

import java.util.List;

/**
 * @author xunmi
 * @ClassName BookService
 * @Description TODO
 * @Date 2020/3/28
 * @Version 1.0
 **/
public interface BookService {
    /**
     * 查询所有的话题数据
     * @return List<Book>
     */
    List<Book> queryAll();

    /**
     * 批量插入
     * @param book 专题信息
     * @return int[]
     */
    int[] batchInsert(List<Book> book);

    /**
     * 新增一个
     * @param book 专题信息
     */
    void addBook(Book book);
}
