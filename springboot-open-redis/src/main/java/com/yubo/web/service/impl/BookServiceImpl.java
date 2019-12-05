package com.yubo.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yubo.web.common.result.RestResult;
import com.yubo.web.common.result.RestResultFactory;
import com.yubo.web.entity.Book;
import com.yubo.web.mapper.BookMapper;
import com.yubo.web.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 18:11
 * @Description:
 */

@Transactional
@Service
public class BookServiceImpl implements BookService {

    private static Logger logger = LogManager.getLogger(BookServiceImpl.class);

    @Autowired
    BookMapper bookMapper;

    public RestResult add(Book book) {
        bookMapper.insert(book);
        return RestResultFactory.successMessage("数据添加成功");
    }

    @CachePut(cacheNames = "book", key = "#p0.id")
    public Book update(Book book) {
        bookMapper.update(book);
        return bookMapper.selectByBook(book);
    }

    @Cacheable(cacheNames = "book", key = "#p0.id")
    public Book get(Book book) {

        book = bookMapper.selectByBook(book);

        logger.info("返回数据:" + JSONObject.toJSONString(book));

        return book;
    }

    @Cacheable(cacheNames = "book")
    public List<Book> list() {

        List<Book> bookList = bookMapper.selectList();

        logger.info("返回数据:" + JSONObject.toJSONString(bookList));

        return bookList;

    }

}
