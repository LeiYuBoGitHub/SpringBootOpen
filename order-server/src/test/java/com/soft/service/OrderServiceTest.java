package com.soft.service;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.util.RestTemplateUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 野性的呼唤
 * @Date: 2020/10/20 00:10
 * @Description:
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceTest {

    @Test
    void open() {
        for (int i = 1; i < 100; i++) {
            Map<String, Object> map = new HashMap<>(16);
            map.put("studentId", i);
            RestTemplateUtil.post(JSONObject.toJSONString(map), "http://localhost:8100/order/open");
        }
    }

    @Test
    void callBack() {
    }
}