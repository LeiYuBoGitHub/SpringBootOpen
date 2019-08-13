package com.lyb.service.impl;

import com.lyb.common.result.ResultData;
import com.lyb.common.result.ResultDataFactory;
import com.lyb.entity.User;
import com.lyb.mapper.UserMapper;
import com.lyb.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/8 16:37
 * @Description:
 */

@CacheConfig(cacheNames="userService")
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    public ResultData login(HttpServletRequest request, User user) {

        user = userMapper.login(user);
        if (user == null){
            return ResultDataFactory.createErrorData("未找到该用户!");
        }

        request.getSession().setAttribute("user",user);

        return ResultDataFactory.createSuccess("登录成功!");
    }

    @Cacheable(cacheNames = "user", key="#p0.id")
    public User get(User user) {
        logger.info("执行这里,说明缓存中读取不到数据,直接读取数据库....");
        return userMapper.select(user);
    }

    @Transactional
    @CachePut(cacheNames = "user", key = "#p0.id")
    public User update(User user) {
        userMapper.update(user);
        logger.info("数据库更新完成!");
        return user;
    }


}
