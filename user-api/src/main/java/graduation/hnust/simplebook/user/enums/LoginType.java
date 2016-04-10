/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.user.enums;

import com.google.common.base.Objects;

/**
 * 登录类型
 *
 * Author  : panxin109@gmail.com
 * Date    : 5:44 PM 4/4/16
 */
public enum LoginType {

    MOBILE(1, "手机"),
    EMAIL(2, "邮箱"),
    OTHER(3, "其他");

    private final int value;

    private final String desc;

    LoginType(int number, String desc) {
        this.value = number;
        this.desc = desc;
    }

    public int value(){
        return this.value;
    }

    public static LoginType from(int value) {
        for (LoginType type : LoginType.values()) {
            if (Objects.equal(type.value, value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("unknown.login.type");
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
