/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.common.sms;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import io.terminus.common.model.Response;
import io.terminus.common.utils.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * Author  : panxin
 * Date    : 7:29 PM 3/28/16
 */
@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public Response<Boolean> sendSms(String mobile, SmsModel model) {
        String result = null;
        //JSONObject object = null;
        //JsonMapper mapper = JsonMapper.JSON_NON_DEFAULT_MAPPER;
        try {
            result = doSendSms(mobile, model);
            //boolean success = mapper.toJson(result).contains("alibaba_aliqin_fc_sms_num_send_response");


            //object = JsonObject

            //String code = model.getSmsParamMap().get("code");

        } catch (ApiException e) {
            log.error("failed to send sms error code = {}, msg = {} ", e.getErrCode(), e.getErrMsg());
            return Response.ok(Boolean.FALSE);
        }
        return Response.ok(Boolean.TRUE);
    }

    @Override
    public Response<Boolean> smsVerify(String code, String mobile) {
        return null;
    }

    /**
     * 发送短信
     *
     * @param mobile 手机号
     * @param model 短信模板
     * @return 发送结果
     */
    private String doSendSms(String mobile, SmsModel model) throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(SmsModel.SMS_HTTP_URL, SmsModel.KEY, SmsModel.SECRET);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend(model.getExtend());
        req.setSmsType(model.getSmsType());
        req.setSmsFreeSignName(model.getSmsFreeSignName());
        req.setSmsParam(model.getSmsParam());
        req.setRecNum(model.getRecNum());
        req.setSmsTemplateCode(model.getSmsTemplateCode());
        AlibabaAliqinFcSmsNumSendResponse response = client.execute(req);
        return response.getBody();
    }
}
