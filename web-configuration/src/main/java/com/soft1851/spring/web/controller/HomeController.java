package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.Book;
import com.soft1851.spring.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xunmi
 * @ClassName HomeController
 * @Description TODO
 * @Date 2020/3/24
 * @Version 1.0
 **/
@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Hello Spring MVC~~");
        Book[] books = {
                new Book(1, "Java", "https://mvnrepository.com/img/33c659f6717f864024720ccaf4809165"),
                new Book(2, "Java", "https://static-cdn-oss.mosoteach.cn/mosoteach2/common/images/activities-list-icon-discuss.png"),
                new Book(3, "Java", "https://static-cdn-oss.mosoteach.cn/mosoteach2/common/images/activities-list-icon-assignment.png")
        };
        model.addAttribute("bookList", books);
        return "home";
    }


}
