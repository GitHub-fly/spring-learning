package com.soft1851.spring.orm.config;

import com.soft1851.spring.orm.dao.ForumDao;
import com.soft1851.spring.orm.entity.Forum;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author xunmi
 * @ClassName JdbcConfigTest
 * @Description TODO
 * @Date 2020/3/19
 * @Version 1.0
 **/
public class JdbcConfigTest {

    public static void main(String[] args) {
        // 扫类
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(JdbcConfig.class);
        ForumDao forumDao = (ForumDao) acac.getBean("forumDao");
        List<Forum> forumList = forumDao.selectAll();
        forumList.forEach(System.out::println);
    }
}
