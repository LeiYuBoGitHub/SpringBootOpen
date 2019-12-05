package com.yubo.web.service;

import com.yubo.web.common.result.RestResult;
import com.yubo.web.entity.Book;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 17:59
 * @Description:
 */
public interface BookService {

    RestResult add(Book book);

    RestResult getList();

}
