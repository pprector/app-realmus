package com.realmus.service.converter;

import com.realmus.domain.entity.NavigationEntity;
import com.realmus.facade.param.Navigation;
import com.realmus.facade.response.PageNavigationResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hkpeng
 * @date 2021/12/21 - 11:01
 */

public class NavigationConverter {
    /**
     * 实体转出参
     *
     * @param entityList
     * @return
     */
    public static PageNavigationResponse toPageNavigationResponseList(NavigationEntity entityList) {
        if (entityList == null) {
            return null;
        }
        PageNavigationResponse pageNavigationResponse = new PageNavigationResponse();
        pageNavigationResponse.setId(entityList.getNavigationId());
        pageNavigationResponse.setNavName(entityList.getNavigationName());
        pageNavigationResponse.setH5Url(entityList.getH5Url());
        pageNavigationResponse.setNavTier(entityList.getNavigationTier());

        List<NavigationEntity> sonNavigationList = entityList.getSonNavigationList();
        List<Navigation> navigationList = sonNavigationList.stream().map(NavigationConverter::toNavigation).collect(Collectors.toList());

        pageNavigationResponse.setSubset(navigationList);

        return pageNavigationResponse;
    }


    public static Navigation toNavigation(NavigationEntity entity) {
        if (entity == null) {
            return null;
        }
        Navigation navigation = new Navigation();
        navigation.setId(entity.getNavigationId());
        navigation.setNavName(entity.getNavigationName());
        navigation.setH5Url(entity.getH5Url());
        navigation.setNavTier(entity.getNavigationTier());

        return navigation;
    }

}
