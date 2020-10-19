package com.soft.controller;

import com.soft.common.result.RestResult;
import com.soft.entity.StudentParam;
import com.soft.filter.log.WebLog;
import com.soft.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 野性的呼唤
 * @Date: 2020/1/9 18:09
 * @Description: 生活区接口
 */

@RestController
@RequestMapping("device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @WebLog(description = "open")
    @PostMapping(value = "open", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult open(@RequestBody StudentParam studentParam) {
        return deviceService.open(studentParam);
    }

}
