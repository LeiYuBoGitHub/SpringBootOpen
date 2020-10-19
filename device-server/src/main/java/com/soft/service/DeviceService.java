package com.soft.service;

import com.soft.common.result.RestResult;
import com.soft.entity.StudentParam;

/**
 * @author 野性的呼唤
 * @Date: 2020/10/19 23:10
 * @Description:
 */
public interface DeviceService {

    /**
     * 打开
     * @param studentParam 学生
     * @return 接口
     */
    RestResult open(StudentParam studentParam);

}
