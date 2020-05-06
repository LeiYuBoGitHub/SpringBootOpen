package com.yubo.book.filter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Auther: 野性的呼唤
 * @Date: 2020/5/6 23:56
 * @Description:
 */
@Aspect
@Component
public class ResponseFilter {

    private static Logger logger = LogManager.getLogger(ResponseFilter.class);

    /**
     * 这里注意 Controller 后面是 三个 * 原本默认是两个,但我们的 Controller 下还有文件夹 所以加了一个
     * @param object 入参
     */
    @AfterReturning(returning = "object", pointcut = "execution( * com.yubo.book.controller.*.*(..))")
    public void doAfterReturning(Object object) {
        logger.info("统一返回值:" + JSONObject.toJSONString(object), SerializerFeature.WriteMapNullValue);
    }

}
