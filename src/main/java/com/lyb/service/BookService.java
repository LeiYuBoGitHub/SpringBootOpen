package com.lyb.service;

import com.lyb.common.result.ResultData;
import com.lyb.entity.Book;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 17:59
 * @Description:
 */
public interface BookService {

    ResultData getList();

    Book get(Book book);

    ResultData add(Book book);

    Book update(Book book);

}
