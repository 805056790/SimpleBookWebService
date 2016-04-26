/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.terminus.common.exception.JsonResponseException;
import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.Response;

/**
 * Author  : panxin109@gmail.com
 * Date    : 11:00 PM 4/21/16
 */
public final class ResponseHelper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String error(Response resp) {
        return "{" +
                    "\"result\":\""+false+"\""+
                        ","+
                    "\"msg\":\""+resp.getError()+ "\"" +
                "}";
    }

    public static String ok(Response resp) {
        try {
            return mapper.writeValueAsString(resp.getResult());
        } catch (JsonProcessingException e) {
            throw new JsonResponseException(500, "server.error");
        }
    }

}
