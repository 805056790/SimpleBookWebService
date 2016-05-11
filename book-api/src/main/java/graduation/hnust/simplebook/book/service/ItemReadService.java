/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.book.service;

import graduation.hnust.simplebook.book.model.Item;
import io.terminus.pampas.common.Response;

import java.util.List;

/**
 * Author  : panxin109@gmail.com
 * Date    : 7:39 PM 5/9/16
 */
public interface ItemReadService {

    /**
     * 通过用户ID查找
     *
     * @param userId 用户ID
     * @return items
     */
    Response<List<Item>> findItemsByUserId(Long userId);

}
