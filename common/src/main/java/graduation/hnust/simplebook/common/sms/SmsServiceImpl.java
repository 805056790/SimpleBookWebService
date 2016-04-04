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
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


/**
 * Author  : panxin
 * Date    : 7:29 PM 3/28/16
 */
@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public Response<Boolean> sendSms(SmsModel model) {
        String respMsg = null;
        try {
            respMsg = doSendSms(model);

            // 解析发送短信返回的消息
            JSONObject object = new JSONObject(respMsg);
            object = (JSONObject) object.get(SmsResponse.RESPONSE_OK);
            object = (JSONObject) object.get(SmsResponse.RESPONSE_OK_RESULT);
            Boolean result = object.getBoolean(SmsResponse.RESPONSE_OK_RESULT_SUCCESS);

            if (!result) {
                log.error("failed to send sms, mobile = {}", model.getRecNum());
                Response.ok(Boolean.FALSE);
            }
            // TODO 验证码缓存redis
            return Response.ok(Boolean.TRUE);
        } catch (ApiException e) {
            log.error("failed to send sms error code = {}, msg = {} ", e.getErrCode(), e.getErrMsg());
            return Response.ok(Boolean.FALSE);
        } catch (JSONException e) {
            log.error("failed to send sms error cause ({}) ", e.getCause());
            return Response.ok(Boolean.FALSE);
        } catch (Exception e) {
            log.error("failed to send sms error cause ({}) ", e.getCause());
            return Response.ok(Boolean.FALSE);
        }
    }

    @Override
    public Response<Boolean> smsVerify(String code, String mobile) {
        return null;
    }

    /**
     * 发送短信
     *
     * @param model 短信模板
     * @return 发送结果
     */
    private String doSendSms(SmsModel model) throws ApiException {
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
