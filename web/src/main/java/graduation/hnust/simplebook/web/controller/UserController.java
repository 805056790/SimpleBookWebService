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

/**
 * Author  : panxin
 * Date    : 5:56 PM 3/28/16
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {


    private final SmsService smsService;
    private final UserReadService userReadService;

    private JsonMapper mapper = JsonMapper.nonEmptyMapper();

    @Autowired
    public UserController(SmsService smsService, UserReadService userReadService) {
        this.smsService = smsService;
        this.userReadService = userReadService;
    }

    /**
     * 用户注册
     *
     * @param mobile 手机号
     * @param password 密码
     * @return 注册用户ID, 失败返回error msg
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Long register(String mobile, String password) {
        return null;
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
            log.warn("user already exists. loginType = {}, loginBy = {}", loginType, loginBy);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 密码
     * @param loginBy 登录类型(用户名, 手机, 邮箱)
     * @return 登录用户信息
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public User login(@RequestParam(value = "userName") String userName,
                      @RequestParam(value = "password") String password,
                      @RequestParam(value = "loginBy") Integer loginBy) {
        return null;
    }

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @return 是否发送成功
     */
    @RequestMapping(value = "/send_sms", method = RequestMethod.POST)
    public Boolean sendSms(@RequestParam(value = "mobile") String mobile) {
        checkArgument(notEmpty(mobile), "mobile.empty");

        // 生成验证码
        Map<String, String> paramMap = Maps.newHashMap();
        String code = String.valueOf((int)((Math.random()*9+1)*1000));
        paramMap.put("code", code);
        paramMap.put("product", "SimpleBook(简单记账App:http://simplebook.github.io)");
        String smsParam = mapper.toJson(paramMap);

        // 设置短信模板
        SmsModel model = new SmsModel();
        model.setExtend("123456");
        model.setSmsType(SmsModel.SMS_TYPE);
        model.setSmsFreeSignName(SmsModel.SIGN_REGISTER);
        model.setRecNum(mobile);
        model.setSmsParam(smsParam);
        model.setSmsTemplateCode(SmsModel.TEMPLATE_REGISTER);

        // 发送短信
        Response<Boolean> resp = smsService.sendSms(model);
        if (!resp.isSuccess()) {
            log.error("failed to send sms, mobile = {}", mobile);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 短信验证码校验
     *
     * @param smsCode 验证码
     * @return 是否验证成功
     */
    @RequestMapping(value = "/verify")
    public Boolean verifySmsCode(@RequestParam(value = "smsCode") String smsCode,
                                 @RequestParam(value = "mobile") String mobile) {
        checkArgument(notEmpty(smsCode), "smsCode.empty");
        checkArgument(notEmpty(mobile), "mobile.empty");

        Response<Boolean> resp = smsService.smsVerify(smsCode, mobile);
        if (!resp.isSuccess()) {
            log.error("sms code not match code = {}, mobile = {}", smsCode, mobile);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    //   the following is for test.

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "hello";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User test2(){
        return userReadService.findById(1L).getResult();
    }

}
