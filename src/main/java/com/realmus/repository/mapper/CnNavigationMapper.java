package com.realmus.repository.mapper;

import com.realmus.repository.model.NavigationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/21 - 11:27
 */


@Mapper
public interface CnNavigationMapper {
    /**
     * 查询所有数据
     *
     * @return
     */
    List<NavigationDO> findAllNavigationInfo();
}