package com.lyb.service.impl;

import com.lyb.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/8 14:27
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookServiceImplTest {

    @Autowired
    BookService bookService;

    @Test
    void getList() {
        bookService.getList();
    }
}