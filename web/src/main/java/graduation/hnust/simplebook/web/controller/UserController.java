/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.web.controller;

import com.google.common.collect.Maps;
import graduation.hnust.simplebook.common.core.JsonMapper;
import graduation.hnust.simplebook.message.sms.SmsModel;
import graduation.hnust.simplebook.message.sms.SmsService;
import graduation.hnust.simplebook.user.enums.LoginType;
import graduation.hnust.simplebook.user.model.User;
import graduation.hnust.simplebook.user.service.UserReadService;
import graduation.hnust.simplebook.user.service.UserWriteService;
import io.terminus.common.exception.JsonResponseException;
import io.terminus.pampas.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static io.terminus.common.utils.Arguments.notEmpty;
import static io.terminus.common.utils.Arguments.notNull;

/**
 * Author  : panxin
 * Date    : 5:56 PM 3/28/16
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserReadService userReadService;
    @Autowired
    private UserWriteService userWriteService;

    /**
     * 用户注册
     *
     * @param mobile 手机号
     * @param password 密码
     * @return 注册用户ID, 失败返回error msg
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Long register(@RequestParam(value = "mobile") String mobile,
                         @RequestParam(value = "password") String password,
                         @RequestParam(value = "userType") Integer userType) {
        // 校验用户是否存在
        Response<User> respUser = userReadService.findBy(LoginType.from(userType), mobile);
        if (respUser.getResult() != null) {
            log.warn("user already exists. loginType = {}, loginBy = {}, cause : {}", userType, mobile, respUser.getError());
            throw new JsonResponseException(500, respUser.getError());
        }
        // 创建用户信息
        User user = new User();
        user.setMobile(mobile);
        user.setPassword(password);
        user.setStatus(1);
        // 创建用户
        Response<Long> resp = userWriteService.create(user);
        if (!respUser.isSuccess()) {
            log.warn("failed to create user({}), cause : {}", user, respUser.getError());
            throw new JsonResponseException(500, resp.getError());
        }
        return resp.getResult();
    }

    /**
     * 检测用户是否已存在
     *
     * @param loginType 登录类型
     * @param loginBy 登录账号
     * @return 是否已存在, 已存在: true, 不存在: false
     */
    @RequestMapping(value = "/exists", method = RequestMethod.GET)
    public Boolean userExists(@RequestParam(value = "loginType") Integer loginType,
                              @RequestParam(value = "loginBy") String loginBy) {
        checkArgument(notEmpty(loginBy), "login.by.empty");

        Response<User> resp = userReadService.findBy(LoginType.from(loginType), loginBy);
        if (resp.isSuccess()) {
            log.warn("user already exists. loginType = {}, loginBy = {}, cause : {}", loginType, loginBy, resp.getError());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 用户登录
     *
     * @param loginBy 用户名
     * @param password 密码
     * @param loginType 登录类型(用户名, 手机, 邮箱)
     * @return 登录用户信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestParam(value = "loginBy") String loginBy,
                      @RequestParam(value = "password") String password,
                      @RequestParam(value = "loginType") Integer loginType) {
        // 数据校验
        checkArgument(notEmpty(loginBy), "user.userName.is.empty");
        checkArgument(notEmpty(password), "user.password.is.empty");
        checkArgument(notNull(loginType), "user.login.type.is.empty");

        // 登录
        Response<User> resp = userReadService.login(loginBy, password, loginType);
        if (!resp.isSuccess()) {
            log.error("failed to login by user(loginBy = {}, password = {}, loginType = {}), cause: {}",
                    loginBy, password, loginType, resp.getError());
            throw new JsonResponseException(500, resp.getError());
        }
        return resp.getResult();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "hello";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User test2(){
        return userReadService.findById(1L).getResult();
    }

}
