package com.realmus.repository.impl;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.enums.TierEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.domain.entity.NavigationEntity;
import com.realmus.domain.repository.NavigationRepository;
import com.realmus.repository.converter.DoTOEntity;
import com.realmus.repository.converter.EntityToDo;
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
    public List<NavigationEntity> getNavigationChineseInfo(LanguageEnum languageEnum) {
        List<NavigationDO> navigationDOList = null;
        switch (languageEnum) {
            case CHINESE:
                navigationDOList = cnNavigationMapper.findAllNavigationInfo();
                break;
            case ENGLISH:
                throw new BizException(BizErrorEnum.A001);
        }

        //数据处理
        return toNavigationEntityList(navigationDOList);
    }

    /**
     * 查询扩展信息
     *
     * @param languageEnum
     * @param navigationId
     * @return
     */
    @Override
    public NavigationEntity findExtendInfo(LanguageEnum languageEnum, String navigationId) {
        NavigationDO navigationDO = null;
        NavigationEntity navigationEntity = null;
        switch (languageEnum) {
            case CHINESE:
                navigationDO = cnNavigationMapper.findNavigationInfoById(navigationId);
                navigationEntity = DoTOEntity.toNavigationEntity(navigationDO);
                break;
            case ENGLISH:
                throw new BizException(BizErrorEnum.A001);
        }
        return navigationEntity;
    }

    @Override
    public void updateNavigationInfo(LanguageEnum languageEnum, NavigationEntity navigation) {
        NavigationDO navigationDO = EntityToDo.toNavigationDO(navigation);
        switch (languageEnum) {
            case CHINESE:
                cnNavigationMapper.updateByPrimaryKeySelective(navigationDO);
                break;
            case ENGLISH:
                throw new BizException(BizErrorEnum.A001);
        }

    }


    private List<NavigationEntity> toNavigationEntityList(List<NavigationDO> navigationDOList) {
        //LV1
        List<NavigationEntity> navigationEntityList =
                navigationDOList.stream().filter(navigationDO -> {
                    return navigationDO.getNavigationTier().equals(TierEnum.LV1.getCode());
                }).sorted(Comparator.comparing(NavigationDO::getWeight).reversed()
                ).map(DoTOEntity::toNavigationEntity)
                        .collect(Collectors.toList());
        //LV2
        List<NavigationEntity> navigationEntityLv2List =
                navigationDOList.stream().filter(navigationDO -> {
                    return navigationDO.getNavigationTier().equals(TierEnum.LV2.getCode());
                }).map(DoTOEntity::toNavigationEntity).collect(Collectors.toList());
        //数据组装
        for (NavigationEntity entity : navigationEntityList) {
            List<NavigationEntity> entityItem = navigationEntityLv2List.stream().filter(item -> {
                return entity.getNavigationId().equals(item.getNavigationParentId());
            }).collect(Collectors.toList());

            entity.setSonNavigationList(entityItem);
        }
        return navigationEntityList;
    }
}
