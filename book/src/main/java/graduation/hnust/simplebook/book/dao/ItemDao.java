/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.book.dao;

import graduation.hnust.simplebook.book.model.Item;
import io.terminus.common.mysql.dao.MyBatisDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author  : panxin109@gmail.com
 * Date    : 7:32 PM 5/9/16
 */
@Repository
public class ItemDao extends MyBatisDao<Item> {

    /**
     * 通过用户ID查找
     *
     * @param userId 用户ID
     * @return items
     */
    public List<Item> findByUserId(Long userId) {
        return getSqlSession().selectList("findByUserId", userId);
    }

}
