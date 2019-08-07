package com.lyb.controller;

import com.lyb.common.result.ResultData;
import com.lyb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 18:21
 * @Description:
 */

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @ResponseBody
    @RequestMapping("list")
    public ResultData list() {
        return bookService.getList();
    }
}
