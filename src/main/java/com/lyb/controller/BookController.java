package com.lyb.controller;

import com.lyb.common.result.ResultData;
import com.lyb.common.result.ResultDataFactory;
import com.lyb.entity.Book;
import com.lyb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ResponseBody
    @RequestMapping(value = "get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResultData get(@RequestBody Book book) {
        return ResultDataFactory.createSuccessData(bookService.get(book));
        //return bookService.get(book);
    }

    @ResponseBody
    @RequestMapping(value = "add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResultData add(@RequestBody Book book) {
        return bookService.add(book);
    }

    @ResponseBody
    @RequestMapping(value = "update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResultData update(@RequestBody Book book) {
        bookService.update(book);
        return ResultDataFactory.createSuccess("更新成功!");
    }
}
