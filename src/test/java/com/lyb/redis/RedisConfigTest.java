package com.lyb.redis;

import com.lyb.entity.Book;
import com.lyb.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/8 14:00
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RedisConfigTest {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    void redisTemplate() {

        List<Book> bookList = bookMapper.selectList();

        ValueOperations<String,Object> vo = redisTemplate.opsForValue();

        vo.set("book",bookList);

    }
}