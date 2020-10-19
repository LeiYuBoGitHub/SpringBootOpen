package com.soft.controller;

import com.soft.common.result.RestResult;
import com.soft.entity.StudentParam;
import com.soft.filter.log.WebLog;
import com.soft.service.OrderService;
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
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @WebLog(description = "open")
    @PostMapping(value = "open", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult open(@RequestBody StudentParam studentParam) {
        return orderService.open(studentParam);
    }

    @WebLog(description = "callBack")
    @PostMapping(value = "callBack", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResult callBack(@RequestBody StudentParam studentParam) {
        return orderService.callBack(studentParam);
    }

}
