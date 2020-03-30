package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.service.BookService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xunmi
 * @ClassName BookController
 * @Description TODO
 * @Date 2020/3/28
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/", produces = "application/json; charset=utf-8")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "books")
    @ResponseBody
    public String getBooks() {
        ResponseObject rs = new ResponseObject(1, "success", bookService.queryAll());
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("/book")
    public String topic(Model model) {
        model.addAttribute("books", bookService.queryAll());
        return "book";
    }
}
