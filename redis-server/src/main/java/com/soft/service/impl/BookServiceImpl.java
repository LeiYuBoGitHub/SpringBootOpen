package com.soft.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft.common.result.RestResult;
import com.soft.common.result.RestResultFactory;
import com.soft.entity.bean.BookBean;
import com.soft.entity.param.BookParam;
import com.soft.mapper.BookMapper;
import com.soft.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 18:11
 * @Description:
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class BookServiceImpl implements BookService {

    private static Logger logger = LogManager.getLogger(BookServiceImpl.class);

    @Autowired
    BookMapper bookMapper;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public RestResult add(BookParam bookParam) {
        return null;
    }

    @Override
    public RestResult get(BookParam bookParam) {

        // 获取数据
        JSONObject jsonObject = (JSONObject) redisTemplate.opsForValue().get("book:" + bookParam.getId());
        BookBean bookBean;
        if (jsonObject == null) {
            bookBean = bookMapper.selectById(bookParam.getId());
            redisTemplate.opsForValue().set("book:" + bookParam.getId(), bookBean,  20, TimeUnit.SECONDS);
        } else {
            bookBean = jsonObject.toJavaObject(BookBean.class);
        }

        Map<String, Object> map = new HashMap<>(16);
        map.put("id", bookBean.getId());
        map.put("name", bookBean.getBookName());

        return RestResultFactory.successResult(map);
    }
}
