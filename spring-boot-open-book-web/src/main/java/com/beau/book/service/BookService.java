package com.beau.book.service;

import com.beau.book.common.result.RestResult;
import com.beau.book.entity.Book;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 17:59
 * @Description:
 */
public interface BookService {

    RestResult add(Book book);

    RestResult get(Long id);

    RestResult list();

}
