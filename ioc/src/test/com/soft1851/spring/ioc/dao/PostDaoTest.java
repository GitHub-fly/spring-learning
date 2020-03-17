package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDaoTest {

    @Autowired
    private PostDao postDao;

    @Test
    public void insert() {
        Post post = Post.builder().forumId(1).content("测试1").build();
        int n = postDao.insert(post);
        assertEquals(1, n);
        System.out.println(n);
    }

    @Test
    public void batchInsert() {
        Post[] posts = {
                Post.builder().forumId(3).content("测试1").build(),
                Post.builder().forumId(3).content("测试2").build(),
                Post.builder().forumId(3).content("测试3").build(),
                Post.builder().forumId(3).content("测试4").build(),
                Post.builder().forumId(3).content("测试5").build(),
                Post.builder().forumId(3).content("测试6").build(),
        };
        List<Post> postList = Arrays.asList(posts);
        int[] rows = postDao.batchInsert(postList);
        assertEquals(6, rows.length);
    }

    @Test
    public void delete() {
        int n = postDao.delete(3);
        assertEquals(1, n);
    }

    @Test
    public void selectByWords() {
        List<Post> postList = postDao.selectByKey("1");
        postList.forEach(item -> System.out.println(item.getPostId()));
    }

    @Test
    public void count() {
        int i = 1;
        System.out.println(postDao.count(i));
    }
}