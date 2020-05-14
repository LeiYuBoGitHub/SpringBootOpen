package com.beau.book.service;

import com.beau.book.common.result.RestResult;
import com.beau.book.entity.Book;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 17:59
 * @Description:
 */
public interface BookService {

    /**
     * 添加
     * @param book 对象
     * @return 对象
     */
    RestResult add(Book book);

    /**
     * 修改
     * @param book 对象
     * @return 对象
     */
    RestResult update(Book book);

    /**
     * 获取
     * @param id 属性
     * @return 对象
     */
    RestResult get(Long id);

    /**
     * 获取集合
     * @return 对象
     */
    RestResult list();

}
