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
import org.springframework.cache.annotation.Cacheable;
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

        logger.info("返回数据:" + JSONObject.toJSONString(bookList));

        return RestResultFactory.successResult(bookList);

    }
}
