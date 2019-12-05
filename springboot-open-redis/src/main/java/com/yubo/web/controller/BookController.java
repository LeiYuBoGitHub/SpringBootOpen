package com.yubo.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.yubo.web.common.result.RestResult;
import com.yubo.web.common.result.RestResultFactory;
import com.yubo.web.entity.Book;
import com.yubo.web.service.BookService;
import com.yubo.web.service.impl.BookServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 18:21
 * @Description:
 */

@RestController
@RequestMapping("book")
public class BookController {

    private static Logger logger = LogManager.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @PostMapping(value = "add", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult sweepCodeOpen(@RequestBody Book book) {
        return bookService.add(book);
    }

    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult update(@RequestBody Book book) {
        logger.info(JSONObject.toJSONString(book));
        book = bookService.update(book);
        return RestResultFactory.successResult(book,"更新成功!");
    }

    @GetMapping("list")
    public RestResult list() {
        return RestResultFactory.successResult(bookService.list());
    }

    @GetMapping("get")
    public RestResult get(Book book) {
        return RestResultFactory.successResult(bookService.get(book));
    }
}
