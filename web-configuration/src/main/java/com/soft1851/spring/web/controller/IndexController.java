package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.Card;
import com.soft1851.spring.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author xunmi
 * @ClassName IndexController
 * @Description TODO
 * @Date 2020/3/24
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/indexController")
public class IndexController {
    @GetMapping("/index")
    public String getUser(Model model) {
        User user = new User("张三", "男",
                18, "http://ww1.sinaimg.cn/large/005Q1gFaly1gd53wvs0naj31i2109doo.jpg");
        model.addAttribute("user", user);


        Card[] cards = {
                new Card("https://cdn.sspai.com/article/28fd79f0-02cd-6305-62c1-dee8c08a5927.jpg?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "一日一技", "用一条指令在新款 Mac 上找回经典的开机启动声", "50分钟前" ),
                new Card("https://cdn.sspai.com/2020/03/15/7412a84b985455fd4935d0e524dad3ad.png?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "App+1", "用一条指令在新款 Mac 上找回经典的开机启动声", "4小时前" ),
                new Card("https://cdn.sspai.com/article/f846fc77-5ac8-d315-7774-c8c6f7ce372d.jpg?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "DIY 出国留学", "Offer 奖学金大满贯经验", "3月16日" ),
                new Card("https://cdn.sspai.com/article/8bee3b68-eb0f-6f53-cdb9-b387f55a9f9a.jpg?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "派评", "微信支持深色模式，近期值得关注的 17 款 App", "1天前")
        };
        List<Card> list = Arrays.asList(cards);
        model.addAttribute("cards", list);
        return "index";
    }


    @GetMapping("/test")
    public String getUer(Model model) {

        return "test";
    }
}
