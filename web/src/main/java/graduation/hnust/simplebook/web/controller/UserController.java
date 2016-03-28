/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.web.controller;

import com.google.common.collect.Maps;
import graduation.hnust.simplebook.common.sms.SmsModel;
import graduation.hnust.simplebook.common.sms.SmsService;
import graduation.hnust.simplebook.user.model.User;
import graduation.hnust.simplebook.user.service.UserReadService;
import graduation.hnust.simplebook.user.service.UserWriteService;
import io.terminus.common.model.Response;
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
                      @RequestParam(value = "loginBy") String loginBy) {
        return null;
    }

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @return 是否发送成功
     */
    @RequestMapping(value = "/send_sms", method = RequestMethod.GET)
    public Boolean sendSms(@RequestParam(value = "mobile") String mobile) {
        checkArgument(notEmpty(mobile), "mobile.empty");

        // 生成验证码
        Map<String, String> paramMap = Maps.newHashMap();
        String code = String.valueOf((int)((Math.random()*9+1)*100000));

        // 设置短信模板
        SmsModel model = new SmsModel();
        paramMap.put("code", code);
        paramMap.put("product", "SimpleBook(简单记账App:http://www.simplebook.cn)");
        model.setExtend("123456");
        model.setSmsType(SmsModel.SMS_TYPE);
        model.setSmsFreeSignName(SmsModel.SIGN_REGISTER);
        model.setRecNum("18673231309");
        model.setSmsTemplateCode(SmsModel.TEMPLATE_REGISTER);

        Response<Boolean> resp = smsService.sendSms(mobile, model);
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
    public Boolean verifySmsCode(@RequestParam(value = "smsCode") String smsCode) {
        return false;
    }

}
