package com.soft1851.spring.ioc;

import com.soft1851.spring.ioc.config.BookConfig;
import com.soft1851.spring.ioc.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BookConfig.class})
//@ContextConfiguration(locations = {"/beans.xml"})
public class BookConfigTest {

    @Autowired
    private Book bookPlus;

    @Test
    public void test() {
        System.out.println(bookPlus.toString());
    }

}