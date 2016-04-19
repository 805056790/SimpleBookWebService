/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.user.service;

import com.google.common.base.Throwables;
import graduation.hnust.simplebook.common.core.Encrypt;
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
    public UserReadServiceImpl(UserDao userDao) {
        this.userDao = userDao;
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
        User user = null;
        try{
            user = userDao.findById(id);
        } catch (Exception e) {
            log.error("failed to find user by userId = {}, cause = {}", id, Throwables.getStackTraceAsString(e));
            return Response.fail("user.found.failed");
        }
        return Response.ok(user);
    }

    @Override
    public Response<User> findByQqToken(String qqToken) {
        // TODO
        return null;
    }

    @Override
    public Response<User> findByQqOpenId(String openId) {
        // TODO
        return null;
    }

    @Override
    public Response<User> login(String loginBy, String password, Integer loginType) {
        Response<User> respUser = null;
        try{
            // 检测用户是否存在
            respUser = this.findBy(LoginType.from(loginType), loginBy);

            // 判断用户状态是否可用
            // TODO switch (respUser.getResult().getStatus())

            // 判断密码是否匹配
            if (!Encrypt.match(password, respUser.getResult().getPassword())) {
                log.error("user(loginBy = {}, loginType = {})'s password mismatch, login failed.", loginBy, loginType );
                return Response.fail("user.password.mismatch");
            }
        } catch (Exception e) {
            log.error("failed to login, loginBy = {}, password = {}, loginType {}, cause : {}",
                    loginBy, password, loginType, Throwables.getStackTraceAsString(e));
            return Response.fail("user.login.failed");
        }
        return respUser;
    }
}
