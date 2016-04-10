/*
 * Copyright (c) 2016. 杭州端点网络科技有限公司.  All rights reserved.
 */

package graduation.hnust.simplebook.common.core;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Author  : panxin109@gmail.com
 * Date    : 9:45 PM 4/4/16
 */
public abstract class MyBatisBaseDao<T> {

    @Autowired
    private SqlSessionTemplate sqlSession;

    protected static final String CREATE = "create";	    //添加
    protected static final String CREATES = "creates";	    //批量添加
    protected static final String DELETE = "delete";	    //删除
    protected static final String DELETES = "deletes";	    //批量删除
    protected static final String UPDATE = "update";	    //更新
    protected static final String FIND_BY_ID = "findById";		    //单个主键查询对象
    protected static final String FIND_BY_IDS = "findByIds";		//主键列表查询对象列表
    protected static final String LIST = "list";		    //列表条件查询
    protected static final String COUNT = "count";		    //计数
    protected static final String PAGING = "paging";	    //分页查询

    /**
     * 添加记录
     *
     * @return 是否添加结果
     */
    Boolean create(T t) {
        return sqlSession.insert(CREATE, t) == 1;
    }

    /**
     * 删除记录
     *
     * @return 是否删除结果
     */
    Boolean delete(T t) {
        return null;
    }

    /**
     * 更新记录
     *
     * @return 是否更新结果
     */
    Boolean update(T t) {
        return null;
    }

    /**
     * 通过ID查找
     *
     * @param id ID
     * @return 泛型对象
     */
    T findById(Integer id) {
        return findById(Long.valueOf(id));
    }

    /**
     * 通过ID查找
     *
     * @param id ID
     * @return 泛型对象
     */
    T findById(Long id) {
        return null;
    }

    /**
     * 批量查询
     *
     * @param ids IDs
     * @return 泛型对象集合
     */
    List<T> findByIds(List<T> ids) {
        return null;
    }

    /**
     * 条件查询
     *
     * @param criteria 条件
     * @return 结果
     */
    List<T> list(Map criteria) {
        return null;
    }

    protected SqlSessionTemplate getSqlSession() {
        return this.sqlSession;
    }

}
