package com.yubo.web.service;

import com.yubo.web.common.util.HttpUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * @Authour: 野性的呼唤
 * @Create: 2019/11/22 22:11
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpServiceTest {

    private static Logger logger = LogManager.getLogger(HttpServiceTest.class);

    @Autowired
    HttpService httpService;
    int size = 10000;
    @Test
    void get() {
        int t = 0;
        int c = 0;
        long startTime = System.currentTimeMillis();
        logger.info("开始时间:" + startTime);
        for(int i = 0; i < size; i++) {
            String url = "http://localhost:8762/user/user";
            String res = httpService.get(url);
            logger.info("输出结果:" + res);

            if (res.contains("Tom")) {
                t++;
            }
            if (res.contains("Count")) {
                c++;
            }
        }

        long endTime = System.currentTimeMillis();
        logger.info("结束时间:" + endTime);
        logger.info("结束时间:" + (endTime - startTime));
        logger.info("t:" + t);
        logger.info("c:" + c);
    }

    @Test
    void defaultGet() {
        long startTime = System.currentTimeMillis();
        logger.info("开始时间:" + startTime);
        for(int i = 0; i < size; i++) {
            String url = "http://localhost:8501/book/list";
            String res = httpService.defaultGet(url);
            logger.info("输出结果:" + res);
        }
        long endTime = System.currentTimeMillis();
        logger.info("结束时间:" + endTime);
        logger.info("结束时间:" + (endTime - startTime));
    }

    @Test
    void defaultGetPlus() {
        long startTime = System.currentTimeMillis();
        logger.info("开始时间:" + startTime);
        for(int i = 0; i < size; i++) {
            String url = "http://localhost:8501/book/list";
            String res = httpService.defaultGetPlus(url);
            logger.info("输出结果:" + res);
        }
        try {
            if (HttpUtil.httpClient != null) {
                HttpUtil.httpClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        logger.info("结束时间:" + endTime);
        logger.info("结束时间:" + (endTime - startTime));
    }

}