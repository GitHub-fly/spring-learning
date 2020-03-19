package com.soft1851.spring.orm.config.config;

import com.soft1851.spring.orm.config.JdbcConfig;
import com.soft1851.spring.orm.dao.ForumDao;
import com.soft1851.spring.orm.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JdbcConfig.class})
//@ContextConfiguration(locations = {"/applicationContext.xml"})
public class JdbcConfigTest {

    @Autowired
    private ForumDao forumDao;

    @Test
    public void testJdbcConfig() {
        List<Forum> list = forumDao.selectAll();
        list.forEach(System.out::println);
    }

}