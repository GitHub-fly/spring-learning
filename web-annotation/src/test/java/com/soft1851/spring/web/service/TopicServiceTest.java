package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.util.JueJinSpider;
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
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void queryAll() {
    }

    @Test
    public void batchInsert() {
        List<Topic> topicList = JueJinSpider.getTopics();
        int[] ints = topicService.batchInsert(topicList);
        assertEquals(topicList.size(), ints.length);
    }

    @Test
    public void addTopic() {
        Topic topic = Topic.builder()
                .id("3123")
                .topicIcon("test")
                .topicIcon("1.png")
                .description("test")
                .msgCount(123)
                .followersCount(123)
                .followed(true)
                .build();
        topicService.addTopic(topic);
    }
}