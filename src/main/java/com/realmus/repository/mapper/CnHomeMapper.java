package com.realmus.repository.mapper;

import com.realmus.repository.model.HomeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/21 - 11:25
 */


@Mapper
public interface CnHomeMapper {
    /**
     * 查询全量 Home 信息
     *
     * @return
     */
    List<HomeDO> findAllHomeInfo();
}