package com.soft.service;

import com.soft.common.result.RestResult;
import com.soft.entity.param.BookParam;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 17:59
 * @Description:
 */
public interface BookService {

    RestResult add(BookParam bookParam);

    RestResult get(BookParam bookParam);

}
