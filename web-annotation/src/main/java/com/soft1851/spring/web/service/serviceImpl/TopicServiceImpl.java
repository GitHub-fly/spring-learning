package com.soft1851.spring.web.service.serviceImpl;

import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xunmi
 * @ClassName TopicServiceImpl
 * @Description @Transactional(rollbackFor = Exception.class)，若果类加了这个注解，那么这个类里面的方法抛出异常，
 * 就会回滚，数据库里面的数据也会回滚
 * @Date 2020/3/27
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Topic> queryAll() {
        return topicDao.selectAll();
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        return topicDao.batchInsert(topics);
    }

    @Override
    public void addTopic(Topic topic) {
        topicDao.insert(topic);
    }
}
