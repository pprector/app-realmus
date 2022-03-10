package com.realmus.domain.repository;

import com.realmus.domain.entity.InformEntity;

/**
 * @author hkpeng
 * 操作  表单信息接口
 * @date 2022/3/9 - 15:04
 */

public interface InformRepository {
    /**
     * 表单信息新增
     *
     * @param entity
     */
    void addInform(InformEntity entity);
}
