package com.lyb.controller;

import com.lyb.common.result.ResultData;
import com.lyb.common.result.ResultDataFactory;
import com.lyb.entity.Book;
import com.lyb.entity.User;
import com.lyb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/9 15:52
 * @Description:
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResultData get(@RequestBody User user) {
        return ResultDataFactory.createSuccessData(userService.get(user));
    }

    @ResponseBody
    @RequestMapping(value = "update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResultData update(@RequestBody User user) {
        userService.update(user);
        return ResultDataFactory.createSuccess("更新成功!");
    }
}
