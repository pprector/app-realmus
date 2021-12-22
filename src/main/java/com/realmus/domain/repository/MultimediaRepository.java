package com.realmus.domain.repository;

import com.realmus.domain.entity.MultimediaEntity;

/**
 * @author hkpeng
 * 查询媒体信息操作
 * @date 2021/12/22 - 16:00
 */

public interface MultimediaRepository {
    /**
     * 根据关联Id 获取一个媒体信息
     *
     * @param relationId
     * @return
     */
    MultimediaEntity getMultimediaEntityOne(String relationId);
}
