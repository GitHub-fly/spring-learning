package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.entity.Forum;
import com.soft1851.spring.web.service.ForumService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xunmi
 * @ClassName ForumController
 * @Description TODO
 * @Date 2020/3/21
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "forum", produces = "application/json; charset=UTF-8")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @GetMapping(value = "/list")
    public String getForums() {
        ResponseObject ro = new ResponseObject(1, "成功", forumService.selectAll());
        return JSON.toJSONString(ro);
    }

    @PutMapping(value = "/insert")
    public String insertForum(List<Forum> forumList) {
        ResponseObject ro = new ResponseObject(1, "成功", forumService.batchInsert(forumList));
        return JSON.toJSONString(ro);
    }

    @PutMapping(value = "/test")
    public String test(String test) {
        System.out.println(test);
        return JSON.toJSONString(test);
    }

}
