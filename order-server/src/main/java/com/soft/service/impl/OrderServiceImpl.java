package com.soft.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.config.RedisKeyConfig;
import com.soft.common.result.RestResult;
import com.soft.common.result.RestResultFactory;
import com.soft.common.util.RestTemplateUtil;
import com.soft.entity.DeviceOpenState;
import com.soft.entity.StudentParam;
import com.soft.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 野性的呼唤
 * @Date: 2020/10/19 23:09
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    private Map<String, DeviceOpenState> startMap = new HashMap<>();

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public RestResult open(StudentParam studentParam) {

        long start = System.currentTimeMillis();

        //机器状态重置为关闭,并存入缓存
        DeviceOpenState deviceOpenState = new DeviceOpenState();
        deviceOpenState.setStudentId(studentParam.getStudentId().toString());
        deviceOpenState.setFlag(false);
        redisTemplate.opsForValue().set(RedisKeyConfig.DEVICE_OPEN_STATE + deviceOpenState.getStudentId(), deviceOpenState);

        Map<String, Object> map = new HashMap<>(16);
        map.put("studentId", studentParam.getStudentId());
        RestTemplateUtil.post(JSONObject.toJSONString(map), "http://localhost:8101/device/open");

        boolean flag = false;
        synchronized (this) {
            try {
                flag = this.waitRequestState(deviceOpenState.getStudentId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        if (flag) {
            return RestResultFactory.successMessage("开启成功:" + studentParam.getStudentId() + "耗时:" + (end-start));
        }
        return RestResultFactory.successMessage("开启失败:" + studentParam.getStudentId() + "耗时:" + (end-start));
    }

    private boolean waitRequestState(String studentId) throws InterruptedException {
        logger.info("准备等待");
        this.wait(5000);
        //从缓存中获取数据
        JSONObject deviceOpenStateJsonObject = (JSONObject) redisTemplate.opsForValue().get(RedisKeyConfig.DEVICE_OPEN_STATE + studentId);
        if (deviceOpenStateJsonObject == null) {
            return false;
        }
        logger.info("DeviceOpenStateJsonObject:" + deviceOpenStateJsonObject.toJSONString());
        return deviceOpenStateJsonObject.toJavaObject(DeviceOpenState.class).isFlag();
    }

    @Override
    public RestResult callBack(StudentParam studentParam) {

        long start = System.currentTimeMillis();

        //从缓存中获取数据
        JSONObject deviceOpenStateJsonObject = (JSONObject) redisTemplate.opsForValue().get(RedisKeyConfig.DEVICE_OPEN_STATE + studentParam.getStudentId().toString());
        if (deviceOpenStateJsonObject == null) {
            logger.error("[" + studentParam.getStudentId() + "]" + "唤醒对象不存在");
            return RestResultFactory.successMessage("[" + studentParam.getStudentId() + "]" + "唤醒对象不存在");
        }
        DeviceOpenState deviceOpenState = deviceOpenStateJsonObject.toJavaObject(DeviceOpenState.class);
        deviceOpenState.setFlag(true);
        redisTemplate.opsForValue().set(RedisKeyConfig.DEVICE_OPEN_STATE + deviceOpenState.getStudentId(), deviceOpenState);
        //唤醒对象
        synchronized (this) {
            logger.info("[" + studentParam.getStudentId() + "]唤醒服务器");
            this.notifyAll();
        }

        long end = System.currentTimeMillis();

        return RestResultFactory.successMessage("回调完成:" + studentParam.getStudentId() + "耗时:" + (end-start));
    }
}
