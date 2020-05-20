package com.beau.book.controller;

import com.beau.book.common.result.RestResult;
import com.beau.book.entity.Book;
import com.beau.book.filter.log.WebLog;
import com.beau.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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

    @WebLog(description = "添加书籍接口")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult add(@RequestBody Book book) {
        return bookService.add(book);
    }

    @WebLog(description = "修改书籍接口")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @WebLog(description = "获取单个书籍接口")
    @GetMapping(value="/{id}")
    public RestResult get(@PathVariable Long id) {
        return bookService.get(id);
    }

    @GetMapping()
    @WebLog(description = "获取所有书籍接口")
    public RestResult list() {
        return bookService.list();
    }

    @GetMapping("download/{id}")
    public void download(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
        bookService.download(id, request, response);
    }
}
