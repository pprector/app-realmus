package com.realmus.repository.mapper;

import com.realmus.domain.entity.NavigationEntity;
import com.realmus.repository.model.NavigationDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/28 - 10:52
 */


@Mapper
public interface CnNavigationMapper {


    /**
     * update  更新导航栏数据
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(NavigationDO record);

    /**
     * 查询所有数据
     *
     * @return
     */
    List<NavigationDO> findAllNavigationInfo();

    /**
     * 根据 Id 查询扩展信息
     *
     * @param navigationId
     * @return
     */
    NavigationDO findNavigationInfoById(@Param("navigationId") String navigationId);

}