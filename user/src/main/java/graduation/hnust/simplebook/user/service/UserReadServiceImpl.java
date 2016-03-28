/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.user.service;

import graduation.hnust.simplebook.user.dao.UserDao;
import graduation.hnust.simplebook.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author  : panxin
 * Date    : 9:24 PM 3/26/16
 */
@Service
public class UserReadServiceImpl implements UserReadService{

    private UserDao userDao;

    @Autowired
    public UserReadServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByMobile(String mobile) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByQqToken(String qqToken) {
        return null;
    }

    @Override
    public User findByQqOpenId(String openId) {
        return null;
    }
}
