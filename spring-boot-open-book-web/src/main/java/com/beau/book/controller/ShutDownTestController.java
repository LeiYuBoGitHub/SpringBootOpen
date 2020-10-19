package com.beau.book.controller;

import com.beau.book.common.result.RestResult;
import com.beau.book.common.result.RestResultFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 野性的呼唤
 * @Date: 2020/5/9 13:24
 * @Description: 测试SpringBoot优雅关闭的接口
 */

@RestController
@RequestMapping("shutDown")
public class ShutDownTestController {

    private static Logger logger = LogManager.getLogger(ShutDownTestController.class);

    @GetMapping()
    public RestResult down() {
        logger.info("**********执行关闭任务开始,10秒后执行完毕**********");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("**********执行关闭任务结束*****");
        return RestResultFactory.successMessage("服务成功关闭");
    }
}
