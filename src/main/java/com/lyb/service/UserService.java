package com.lyb.service;

import com.lyb.common.result.ResultData;
import com.lyb.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/8/8 16:37
 * @Description:
 */
public interface UserService {

    ResultData login(HttpServletRequest request, User user);

    User get(User user);

    User update(User user);


}
