/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.user.dao;


import graduation.hnust.simplebook.common.core.MyBatisBaseDao;
import graduation.hnust.simplebook.user.model.User;
import io.terminus.common.mysql.dao.MyBatisDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Author  : panxin
 * Date    : 9:40 PM 3/26/16
 */
@Repository
public class UserDao extends MyBatisDao<User> {

    /**
     * 通过手机查找
     * @param mobile 账号
     * @return 用户信息
     */
    public User findByMobile(String mobile) {
        return getSqlSession().selectOne(sqlId("findByMobile"), mobile);
    }

    /**
     * 通过邮箱查找
     * @param email 账号
     * @return 用户信息
     */
    public User findByEmail(String email) {
        return getSqlSession().selectOne(sqlId("findByEmail"), email);
    }

    /**
     * 通过其他查找
     * @param loginBy 账号
     * @return 用户信息
     */
    public User findByOther(String loginBy) {
        return getSqlSession().selectOne(sqlId("findByOther"), loginBy);
    }

}
