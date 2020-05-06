package com.yubo.book.service.impl;

import com.yubo.book.common.result.RestResult;
import com.yubo.book.common.result.RestResultFactory;
import com.yubo.book.entity.Book;
import com.yubo.book.mapper.BookMapper;
import com.yubo.book.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 18:11
 * @Description:
 */

@Service
public class BookServiceImpl implements BookService {

    private static Logger logger = LogManager.getLogger(BookServiceImpl.class);

    @Autowired
    BookMapper bookMapper;

    public RestResult add(Book book) {
        bookMapper.insert(book);
        return RestResultFactory.successMessage("数据添加成功");
    }

    public RestResult info(Book book) {
        return RestResultFactory.successResult(bookMapper.select(book));
    }

    public RestResult getList() {
        List<Book> bookList = bookMapper.selectList();
        return RestResultFactory.successResult(bookList);
    }
}
