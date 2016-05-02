/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.web.controller;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import graduation.hnust.simplebook.common.core.JsonMapper;
import graduation.hnust.simplebook.message.sms.SmsModel;
import graduation.hnust.simplebook.message.sms.SmsService;
import io.terminus.pampas.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static io.terminus.common.utils.Arguments.notEmpty;

/**
 * Author  : panxin109@gmail.com
 * Date    : 12:32 PM 4/10/16
 */
@Slf4j
@RestController
@RequestMapping("/api/msg")
public class MessageController {

    private final SmsService smsService;

    private JsonMapper mapper = JsonMapper.nonEmptyMapper();

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String REDIS_KEY = "redis.sms.code";

    @Autowired
    public MessageController(SmsService smsService) {
        this.smsService = smsService;
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

        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String key = REDIS_KEY + mobile;
        if (!redisTemplate.hasKey(key)) {
            ops.set(key, code);
        }else {
            ops.getAndSet(key, code);
        }

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
    @RequestMapping(value = "/verify_sms", method = RequestMethod.POST)
    public Boolean verifySmsCode(@RequestParam(value = "smsCode") String smsCode,
                                 @RequestParam(value = "mobile") String mobile) {
        checkArgument(notEmpty(smsCode), "smsCode.empty");
        checkArgument(notEmpty(mobile), "mobile.empty");
        // Response<Boolean> resp = smsService.smsVerify(smsCode, mobile);
        //if (!resp.isSuccess()) {
        //    log.error("sms code not match code = {}, mobile = {}", smsCode, mobile);
        //    return Boolean.FALSE;
        //}

        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String key = REDIS_KEY + mobile;
        log.info("start to verify smsCode = {}, mobile = {}", smsCode, mobile);

        if(redisTemplate.hasKey(key)) {
            log.info("key was already exists key = {}", key);
            if (Objects.equal(smsCode, ops.get(key))) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
