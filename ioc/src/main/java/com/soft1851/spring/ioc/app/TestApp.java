package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.entity.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author xunmi
 * @ClassName TestApp
 * @Description TODO
 * @Date 2020/3/17
 * @Version 1.0
 **/
public class TestApp {
    public static void main(String[] args) {
        // 生成基于注解配置的应用上下文对象
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();
        // 手动开启扫包
        acac.scan("com.soft1851.spring.ioc.config");
        acac.refresh();
        Book book = (Book) acac.getBean("book");
        book.setName("java");
        book.setPrice(20.8);
        System.out.println(book);
    }
}
