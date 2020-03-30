package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Book;

import java.util.List;

/**
 * @author xunmi
 * @ClassName BookDao
 * @Description TODO
 * @Date 2020/3/28
 * @Version 1.0
 **/
public interface BookDao {

    /**
     * 新增一个
     * @param book 书籍信息
     * @return int
     */
    int insert(Book book);

    /**
     * 批量插入数据
     * @return int[]
     */
    int[] batchInsert(List<Book> list);

    /**
     * 查询所有的书籍信息
     * @return List<Book>
     */
    List<Book> selectAll();
}
