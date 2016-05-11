/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.user.service;

import com.google.common.base.Throwables;
import graduation.hnust.simplebook.common.core.Encrypt;
import graduation.hnust.simplebook.user.dao.UserDao;
import graduation.hnust.simplebook.user.dto.UserDto;
import graduation.hnust.simplebook.user.model.User;
import io.terminus.pampas.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Author  : panxin
 * Date    : 9:26 PM 3/26/16
 */
@Slf4j
@Service
public class UserWriteServiceImpl implements UserWriteService {

    @Autowired
    private UserDao userDao;

    @Autowired
    public UserWriteServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Response<Long> create(User user) {
        Response<Long> resp = new Response<>();
        try {
            if (StringUtils.hasText(user.getPassword())) {
                user.setPassword(Encrypt.encrypt(user.getPassword()));
            }
            userDao.create(user);
            resp.setResult(user.getId());
        } catch (Exception e) {
            log.error("failed to create user({}), cause : {}", user, Throwables.getStackTraceAsString(e));
            Response.fail("user.create.failed");
        }
        return resp;
    }

    @Override
    public Response<Boolean> update(User user) {
        return null;
    }

    @Override
    public Response<Boolean> deleteById(Long id) {
        return null;
    }

    @Override
    public Response<Long> create(UserDto userDto) {
        return null;
    }
}
