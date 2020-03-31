package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.entity.Book;
import com.soft1851.spring.web.util.WangYiYunYueDuSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
    public void batchInsert() {
        List<Book> list = WangYiYunYueDuSpider.getYueDuData();
        System.out.println(list.size());
        int[] ints = bookDao.batchInsert(list);
        assertEquals(list.size(), ints.length);
    }

    @Test
    public void selectAll() {
        bookDao.selectAll().forEach(System.out::println);
    }

    @Test
    public void insert() {
        Book book = Book.builder()
                .title("test")
                .author("test")
                .cover("test")
                .description("test")
                .build();
        bookDao.insert(book);
    }
}
