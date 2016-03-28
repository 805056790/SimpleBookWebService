/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.common.sms;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 短信...
 *
 * Author  : panxin
 * Date    : 6:19 PM 3/28/16
 */
public class SmsModel {

    public static final String KEY = "23333066";
    public static final String SECRET = "1f0fa505ee26b6929a163e89650f6b2a";

    public static final String SMS_TYPE = "normal";

    /**
     * 证书签名
     */
    public static final String SIGN_TEST = "大鱼测试";
    public static final String SIGN_ACTIVITY = "活动验证";
    public static final String SIGN_CHANGE = "变更验证";
    public static final String SIGN_LOGIN = "登录验证";
    public static final String SIGN_REGISTER = "注册验证";
    public static final String SIGN_IDENTITY = "身份验证";

    /**
     * 验证码短信模板 // TODO 文本转语音模板, 暂时不需要
     */
    public static final String TEMPLATE_IDENTITY_VERIFY = "SMS_6755693";    // 身份验证
    public static final String TEMPLATE_SMS_TEST = "SMS_6755692";           // 短信测试
    public static final String TEMPLATE_LOGIN_CONFIRM = "SMS_6755691";      // 登录确认
    public static final String TEMPLATE_LOGIN_EXCEPTION = "SMS_6755690";    // 登陆异常
    public static final String TEMPLATE_REGISTER = "SMS_6755689";           // 用户注册
    public static final String TEMPLATE_ACTIVITY = "SMS_6755688";           // 活动确认
    public static final String TEMPLATE_CHANGE_PASSWORD = "SMS_6755687";    // 修改密码
    public static final String TEMPLATE_CHANGE_INFO = "SMS_6755686";        // 信息变更

    /**
     * 请求地址
     */
    public static final String SMS_HTTP_URL = "http://gw.api.taobao.com/router/rest";
    public static final String SMS_HTTPS_URL = "https://eco.taobao.com/router/rest";

    /**
     * 公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，在消息返回时，
     * 该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用
     */
    @Setter
    @Getter
    private String extend;

    /**
     * 短信类型，传入值请填写normal
     */
    @Setter
    @Getter
    private String smsType;

    /**
     * 短信签名，传入的短信签名必须是在阿里大鱼“管理中心-短信签名管理”中的可用签名。如“阿里大鱼”已在短信签名管理中通过审核，
     * 则可传入”阿里大鱼“（传参时去掉引号）作为短信签名。短信效果示例：【阿里大鱼】欢迎使用阿里大鱼服务。
     */
    @Setter
    @Getter
    private String smsFreeSignName;

    /**
     * 短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。
     * 示例：
     *     针对模板“验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！”，
     *     传参时需传入{"code":"1234","product":"alidayu"}
     */
    @Setter
    @Getter
    private String smsParam;

    /**
     * 短信模板变量，传参规则{"key":"value"},
     * 为了方便参数转换.
     */
    @Setter
    @Getter
    private Map<String, String> smsParamMap;

    /**
     * 短信接收号码。支持单个或多个手机号码，传入号码为11位手机号码，不能加0或+86。群发短信需传入多个号码，以英文逗号分隔，
     * 一次调用最多传入200个号码。示例：18600000000,13911111111,13322222222
     */
    @Setter
    @Getter
    private String recNum;

    /**
     * 短信模板ID，传入的模板必须是在阿里大鱼“管理中心-短信模板管理”中的可用模板。示例：SMS_585014
     */
    @Setter
    @Getter
    private String smsTemplateCode;

    /**
     * 示例代码Java版:
     *
          TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
          AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
          req.setExtend("123456");
          req.setSmsType("normal");
          req.setSmsFreeSignName("阿里大鱼");
          req.setSmsParamString("");
          req.setRecNum("13000000000");
          req.setSmsTemplateCode("SMS_585014");
          AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
          System.out.println(rsp.getBody());
     */

}
