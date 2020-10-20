package com.soft.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.result.RestResult;
import com.soft.common.result.RestResultFactory;
import com.soft.common.util.RestTemplateUtil;
import com.soft.entity.StudentParam;
import com.soft.service.DeviceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 野性的呼唤
 * @Date: 2020/10/19 23:09
 * @Description:
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    private static Logger logger = LogManager.getLogger(DeviceServiceImpl.class);

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public RestResult open(StudentParam studentParam) {
        long start = System.currentTimeMillis();
        new Thread(() -> {
            try {
                logger.info("准备睡眠");
                Thread.sleep(10000);
                logger.info("睡眠完成");
                Map<String, Object> map = new HashMap<>(16);
                map.put("studentId", studentParam.getStudentId());
                RestTemplateUtil.post(JSONObject.toJSONString(map), "http://localhost:8100/order/callBack");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        long end = System.currentTimeMillis();

        return RestResultFactory.successMessage("机器消息:" + studentParam.getStudentId() + "耗时:" + (end-start));
    }

}
