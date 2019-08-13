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
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/7 18:11
 * @Description:
 */
@CacheConfig(cacheNames="bookList")
@Service
public class BookServiceImpl implements BookService {

    private static Logger logger = LogManager.getLogger(BookServiceImpl.class);

    @Resource
    RedisTemplate<String, Book> redisTemplate;

    @Autowired
    BookMapper bookMapper;

    @Cacheable(key="'getList'")
    public ResultData getList() {

        logger.info("执行这里,说明缓存中读取不到数据,直接读取数据库....");

        List<Book> bookList = bookMapper.selectList();
        logger.info("返回数据:" + JSONObject.toJSONString(bookList));

        return ResultDataFactory.createSuccessData(bookList);

    }

    public Book get(Book book) {
        String key = "book::" + book.getId();
        Boolean flag = redisTemplate.hasKey(key);
        if (flag != null) {
            ValueOperations<String, Book> operations = redisTemplate.opsForValue();
            if (flag) {
                logger.info("执行这里,说明缓存中读到数据....");
                return operations.get(key);
            }else{
                logger.info("执行这里,说明缓存中读取不到数据,直接读取数据库....");
                book = bookMapper.selectById(book.getId());
                logger.info("返回数据:" + JSONObject.toJSONString(book));
                operations.set(key, book);
                return book;
            }
        }
        return null;

    }


    public ResultData add(Book book) {
        logger.info("执行这里,说明缓存中读取不到数据,直接读取数据库....");
        bookMapper.insert(book);
        return ResultDataFactory.createSuccess("添加成功!");
    }

    @Transactional
    public Book update(Book book) {
        bookMapper.update(book);
        String key = "book::" + book.getId();
        if (redisTemplate != null) {
            Boolean flag = redisTemplate.hasKey(key);
            logger.info("是否在缓存中存在:" + flag);
            if (flag != null) {
                if (flag) {
                    redisTemplate.delete(key);
                    logger.info("删除缓存完成!");
                }
                book = bookMapper.selectById(book.getId());
                if (book != null) {
                    logger.info("key:" + key);
                    ValueOperations<String, Book> operations = redisTemplate.opsForValue();
                    operations.set(key, book);
                    logger.info("缓存添加完成!");
                }
            }
            return book;
        }
        return null;
    }

}
