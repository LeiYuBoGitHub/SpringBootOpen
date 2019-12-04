package com.yubo.web.controller;

import com.yubo.web.common.result.RestResult;
import com.yubo.web.common.result.RestResultFactory;
import com.yubo.web.entity.Book;
import com.yubo.web.service.BookService;
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

    @Autowired
    BookService bookService;

    @PostMapping(value = "add", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult sweepCodeOpen(@RequestBody Book book) {
        return bookService.add(book);
    }

    @GetMapping("list")
    public RestResult list() {
        return RestResultFactory.successResult(bookService.list());
    }

}
