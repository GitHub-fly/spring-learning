package com.soft1851.spring.web.service.serviceImpl;


import com.soft1851.spring.web.dao.BookDao;
import com.soft1851.spring.web.entity.Book;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xunmi
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Date 2020/3/28
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> queryAll() {
        return bookDao.selectAll();
    }

    @Override
    public int[] batchInsert(List<Book> books) {
        return bookDao.batchInsert(books);
    }

    @Override
    public void addBook(Book book) {
        bookDao.insert(book);
    }
}
