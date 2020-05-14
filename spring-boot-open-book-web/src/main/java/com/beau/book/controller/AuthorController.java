package com.beau.book.controller;

import com.beau.book.common.result.RestResult;
import com.beau.book.entity.Author;
import com.beau.book.filter.log.WebLog;
import com.beau.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 野性的呼唤
 * @Date: 2020/5/14 17:34
 * @Description:
 */

@RestController
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @WebLog(description = "添加作者接口")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult add(@RequestBody Author author) {
        return authorService.add(author);
    }

    @WebLog(description = "获取所有作者接口")
    @GetMapping()
    public RestResult list() {
        return authorService.list();
    }

}
