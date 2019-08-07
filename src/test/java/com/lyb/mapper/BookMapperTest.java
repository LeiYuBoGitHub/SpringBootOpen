package com.lyb.mapper;

import com.lyb.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 17:13
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    void insert() {

        Book book = new Book();
        book.setName("解忧杂货店");

        bookMapper.insert(book);
    }

    @Test
    void selectList() {

        List<Book> bookList = bookMapper.selectList();

        bookList.forEach(book -> System.out.println(book.getName()));
    }


}