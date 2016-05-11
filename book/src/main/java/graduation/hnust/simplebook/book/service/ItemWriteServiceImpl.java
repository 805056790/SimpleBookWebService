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

/**
 * Author  : panxin109@gmail.com
 * Date    : 7:34 PM 5/9/16
 */
@Slf4j
@Service
public class ItemWriteServiceImpl implements  ItemWriteService{

    @Autowired
    private ItemDao itemDao;

    @Override
    public Response<Boolean> create(Item item) {
        try {
            itemDao.create(item);
        }catch (Exception e) {
            log.error("failed to create item({}), cause: {}", item, Throwables.getStackTraceAsString(e));
            return Response.fail("item.create.failed");
        }
        return Response.ok(Boolean.TRUE);
    }
}
