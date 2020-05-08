package com.yubo.book.service;

import com.yubo.book.common.result.RestResult;
import com.yubo.book.entity.Book;
import org.springframework.web.bind.annotation.PathVariable;

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
