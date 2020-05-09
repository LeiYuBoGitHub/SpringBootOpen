package com.yubo.book.controller;

import com.yubo.book.common.result.RestResult;
import com.yubo.book.entity.Book;
import com.yubo.book.filter.log.WebLog;
import com.yubo.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 18:21
 * @Description:
 */

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping(value = "add", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult sweepCodeOpen(@RequestBody Book book) {
        return bookService.add(book);
    }

    @GetMapping(value="/{id}")
    @WebLog(description = "获取单个书籍接口")
    public RestResult get(@PathVariable Long id) {
        return bookService.get(id);
    }

    @GetMapping()
    @WebLog(description = "获取所有书籍接口")
    public RestResult list() {
        return bookService.list();
    }

}
