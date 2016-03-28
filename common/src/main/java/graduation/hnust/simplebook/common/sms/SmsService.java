/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.common.sms;

import io.terminus.common.model.Response;

/**
 * 短信service
 *
 * Author  : panxin
 * Date    : 6:15 PM 3/28/16
 */
public interface SmsService {

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param model 短信模板
     * @return 是否发送成功
     */
    Response<Boolean> sendSms(String mobile, SmsModel model);

    /**
     * 短信验证码校验
     *
     * @param code 验证码
     * @param mobile 手机号
     * @return 是否在验证成功
     */
    Response<Boolean> smsVerify(String code, String mobile);

}
