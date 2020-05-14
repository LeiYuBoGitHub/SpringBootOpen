package com.beau.book.mapper;

import com.beau.book.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Authour: 野性的呼唤
 * @Create: 2019/11/22 21:11
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    void insert() {
    }

    @Test
    void selectList() {
        List<Book> bookList = bookMapper.selectList();
        bookList.forEach(book -> System.out.println(book.getBookName()));
    }
}