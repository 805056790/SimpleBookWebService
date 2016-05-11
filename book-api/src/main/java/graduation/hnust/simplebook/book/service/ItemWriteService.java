/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.book.service;

import graduation.hnust.simplebook.book.model.Item;
import io.terminus.pampas.common.Response;

/**
 * Author  : panxin109@gmail.com
 * Date    : 7:39 PM 5/9/16
 */
public interface ItemWriteService {

    /**
     * 创建Item
     *
     * @param item item
     * @return 是否创建成功
     */
    Response<Boolean> create(Item item);
}
