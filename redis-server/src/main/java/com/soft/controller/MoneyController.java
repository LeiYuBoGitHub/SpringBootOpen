package com.soft.controller;

import com.soft.common.result.RestResult;
import com.soft.entity.param.BookParam;
import com.soft.filter.log.WebLog;
import com.soft.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author 野性的呼唤
 * @Date: 2020/10/12 15:31
 * @Description:
 */
@RestController
@RequestMapping("book")
public class MoneyController {

    @Autowired
    BookService bookService;

    @GetMapping
    @WebLog(description = "查询单个")
    public RestResult change(BookParam bookParam) {
        return bookService.get(bookParam);
    }

    @PostMapping(value = "change", produces = MediaType.APPLICATION_JSON_VALUE)
    @WebLog(description = "金额变更")
    public RestResult change() {
        return null;
    }

}
