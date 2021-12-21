package com.realmus.repository.impl;

import com.realmus.common.enums.TierEnum;
import com.realmus.domain.entity.NavigationEntity;
import com.realmus.domain.repository.NavigationRepository;
import com.realmus.facade.param.Navigation;
import com.realmus.repository.converter.DoTOEntity;
import com.realmus.repository.mapper.CnNavigationMapper;
import com.realmus.repository.model.NavigationDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hkpeng
 * @date 2021/12/21 - 11:29
 */

@Repository
public class NavigationRepositoryImpl implements NavigationRepository {
    @Autowired
    private CnNavigationMapper cnNavigationMapper;


    @Override
    public List<NavigationEntity> getNavigationInfo() {
        List<NavigationDO> navigationDOList = cnNavigationMapper.findAllNavigationInfo();
        //LV1
        List<NavigationEntity> navigationEntityList =
                navigationDOList.stream().filter(navigationDO -> {
                    return navigationDO.getNavigationTier().equals(TierEnum.LV1.getCode());
                }).sorted(Comparator.comparing(NavigationDO::getNavigationTier).reversed()
                ).map(DoTOEntity::toNavigationEntity).collect(Collectors.toList());
        //LV2
        List<NavigationEntity> navigationEntityLv2List =
                navigationDOList.stream().filter(navigationDO -> {
                    return navigationDO.getNavigationTier().equals(TierEnum.LV2.getCode());
                }).sorted(Comparator.comparing(NavigationDO::getNavigationTier).reversed()
                ).map(DoTOEntity::toNavigationEntity).collect(Collectors.toList());
        //数据组装
        for (NavigationEntity entity : navigationEntityList) {
            List<NavigationEntity> entityItem = navigationEntityLv2List.stream().filter(item -> {
                return entity.getNavigationParentId().equals(item.getNavigationParentId());
            }).collect(Collectors.toList());
            entity.setSonNavigationList(entityItem);
        }
        return navigationEntityList;
    }
}
