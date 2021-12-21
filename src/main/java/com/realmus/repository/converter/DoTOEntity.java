package com.realmus.repository.converter;

import com.realmus.domain.entity.NavigationEntity;
import com.realmus.repository.model.NavigationDO;

/**
 * @author hkpeng
 * @date 2021/12/21 - 11:41
 */

public class DoTOEntity {

    public static NavigationEntity toNavigationEntity(NavigationDO navigationDO) {
        if (navigationDO == null) {
            return null;
        }
        NavigationEntity entity = new NavigationEntity();
        entity.setNavigationId(navigationDO.getNavigationId());
        entity.setNavigationName(navigationDO.getNavigationName());
        entity.setH5Url(navigationDO.getNavigationUrl());
        entity.setNavigationTier(navigationDO.getNavigationTier());

        return entity;
    }
}
