/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.user.dao;

import graduation.hnust.simplebook.user.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author  : panxin109@gmail.com
 * Date    : 10:47 PM 4/9/16
 */
public abstract class BaseDao<T> {

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

    protected SqlSessionTemplate getSqlSession() {
        return sqlSessionTemplate;
    }

}
