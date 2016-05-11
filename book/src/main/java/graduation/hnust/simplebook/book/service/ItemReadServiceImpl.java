/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.book.service;

import com.google.common.base.Throwables;
import graduation.hnust.simplebook.book.dao.ItemDao;
import graduation.hnust.simplebook.book.model.Item;
import io.terminus.pampas.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author  : panxin109@gmail.com
 * Date    : 7:34 PM 5/9/16
 */
@Slf4j
@Service
public class ItemReadServiceImpl implements ItemReadService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public Response<List<Item>> findItemsByUserId(Long userId) {
        Response<List<Item>> resp = new Response<>();
        try{
            resp.setResult(itemDao.findByUserId(userId));
        } catch (Exception e) {
            log.error("failed to find items by userId = {}, cause: {}", userId, Throwables.getStackTraceAsString(e));
            return Response.fail("item.found.failed");
        }
        return resp;
    }
}
