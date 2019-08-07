package com.lyb.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lyb.common.result.ResultData;
import com.lyb.common.result.ResultDataFactory;
import com.lyb.entity.Book;
import com.lyb.mapper.BookMapper;
import com.lyb.service.BookService;
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

    public ResultData getList() {

        List<Book> bookList = bookMapper.selectList();

        logger.info("返回数据:" + JSONObject.toJSONString(bookList));

        return ResultDataFactory.createSuccessData(bookList);

    }
}
