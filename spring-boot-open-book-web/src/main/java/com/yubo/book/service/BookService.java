package com.yubo.book.service;

import com.yubo.book.common.result.RestResult;
import com.yubo.book.entity.Book;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 17:59
 * @Description:
 */
public interface BookService {

    RestResult add(Book book);

    RestResult info(Book book);

    RestResult getList();

}
