/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.user.service;

import graduation.hnust.simplebook.user.dao.UserDao;
import graduation.hnust.simplebook.user.enums.LoginType;
import graduation.hnust.simplebook.user.model.User;
import io.terminus.pampas.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author  : panxin
 * Date    : 9:24 PM 3/26/16
 */
@Slf4j
@Service
public class UserReadServiceImpl implements UserReadService{

    @Autowired
    private UserDao userDao;

    @Autowired
    public UserReadServiceImpl(UserDao userMapper) {
        this.userDao = userMapper;
    }

    @Override
    public Response<User> findBy(LoginType loginType, String loginBy) {
        User user = null;
        try {
            switch (loginType) {
                case MOBILE:
                    user = userDao.findByMobile(loginBy);
                    break;
                case EMAIL:
                    user = userDao.findByEmail(loginBy);
                    break;
                case OTHER:
                    user = userDao.findByOther(loginBy);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            log.error("failed to find user : loginType = {}, loginBy = {}", loginType.toString(), loginBy);
            return Response.fail("user.not.exists");
        }
        return Response.ok(user);
    }

    @Override
    public Response<User> findById(Long id) {

        return null;
    }

    @Override
    public Response<User> findByQqToken(String qqToken) {
        return null;
    }

    @Override
    public Response<User> findByQqOpenId(String openId) {
        return null;
    }
}
