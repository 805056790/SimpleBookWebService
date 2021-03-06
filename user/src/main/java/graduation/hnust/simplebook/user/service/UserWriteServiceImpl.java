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
 * Date    : 9:26 PM 3/26/16
 */
@Service
public class UserWriteServiceImpl implements UserWriteService {

    private UserDao userDao;

    @Autowired
    public UserWriteServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Long create(User user) {
        return null;
    }

    @Override
    public Boolean update(User user) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }
}
