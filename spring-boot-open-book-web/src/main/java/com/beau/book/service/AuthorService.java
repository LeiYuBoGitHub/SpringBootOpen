package com.beau.book.service;

import com.beau.book.common.result.RestResult;
import com.beau.book.entity.Author;

/**
 * @Auther: 野性的呼唤
 * @Date: 2020/5/14 17:28
 * @Description:
 */
public interface AuthorService {

    /**
     * 添加
     * @param author 对象
     * @return 对象
     */
    RestResult add(Author author);

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
