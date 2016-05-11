/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.user.dto;

import graduation.hnust.simplebook.user.model.User;
import graduation.hnust.simplebook.user.model.third.QQInfoModel;
import graduation.hnust.simplebook.user.model.third.QQTokenModel;
import lombok.Data;

import java.io.Serializable;

/**
 * Author  : panxin109@gmail.com
 * Date    : 8:45 PM 5/9/16
 */
@Data
public class UserDto implements Serializable{

    private static final long serialVersionUID = 950692928659566119L;

    private User user;

    private QQInfoModel qqInfoModel;

    private QQTokenModel qqTokenModel;
}
