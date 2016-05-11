/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.web.controller;

import graduation.hnust.simplebook.book.model.Item;
import graduation.hnust.simplebook.book.service.ItemReadService;
import graduation.hnust.simplebook.book.service.ItemWriteService;
import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author  : panxin109@gmail.com
 * Date    : 12:38 PM 4/10/16
 */
@Slf4j
@RestController
@RequestMapping("/api/book")
public class BookController {

//    @Autowired
//    private ItemReadService itemReadService;
//
//    @Autowired
//    private ItemWriteService itemWriteService;

    private static JsonMapper MAPPER = JsonMapper.JSON_NON_DEFAULT_MAPPER;

    /**
     * 同步记录
     *
     * @param itemJson item
     * @return 是否同步成功
     */
    @RequestMapping(value = "/sync", method = RequestMethod.POST)
    public String uploadSyncItem(@RequestParam("itemJson") String itemJson,
                                  @RequestParam("userName") String userName) {

        log.info("userName = {}, item json = {}", userName, itemJson);

        Item item = MAPPER.fromJson(itemJson, Item.class);
//        Response<Boolean> resp = itemWriteService.create(item);
//        if (!resp.isSuccess()) {
//            log.error("failed to create item({}), cause: {}", item, resp.getError());
//            return Boolean.FALSE;
//        }
//        return resp.getResult();
        return "sync.success";
    }

    // public String get

}
