package com.realmus.repository.converter;

import com.realmus.common.enums.ModuleEnum;
import com.realmus.common.enums.MultimediaEnum;
import com.realmus.domain.entity.BannerEntity;
import com.realmus.domain.entity.CompanyEntity;
import com.realmus.domain.entity.MultimediaEntity;
import com.realmus.domain.entity.NavigationEntity;
import com.realmus.repository.model.HomeDO;
import com.realmus.repository.model.MultimediaDO;
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
        entity.setNavigationParentId(navigationDO.getNavigationParentId());
        entity.setWeight(navigationDO.getWeight());
        return entity;
    }

    public static BannerEntity toBannerEntity(HomeDO homeDO) {
        if (homeDO == null) {
            return null;
        }
        BannerEntity entity = new BannerEntity();
        entity.setInfoId(homeDO.getInfoId());
        entity.setInfoType(ModuleEnum.getModuleEnum(homeDO.getInfoType()));
        entity.setH5Url(homeDO.getInfoUrl());
        entity.setInfoTitle(homeDO.getInfoTitle());
        entity.setInfoDescription(homeDO.getInfoDescription());
        entity.setInfoContent(homeDO.getInfoContent());

        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setRelationId(homeDO.getRelationId());

        entity.setBannerImg(multimediaEntity);
        return entity;
    }

    public static MultimediaEntity toMultimediaEntity(String relationId, MultimediaDO multimediaDO) {
        if (multimediaDO == null) {
            return null;
        }
        MultimediaEntity entity = new MultimediaEntity();
        entity.setRelationId(relationId);
        entity.setMultimediaId(multimediaDO.getMultimediaId());
        entity.setMultimediaType(MultimediaEnum.getMultimediaEnum(multimediaDO.getMultimediaType()));
        entity.setMultimediaUrl(multimediaDO.getMultimediaUrl());
        entity.setDescription(multimediaDO.getMultimediaDesc());
        return entity;
    }

    public static CompanyEntity toCompanyEntity(HomeDO homeDO) {
        if (homeDO == null) {
            return null;
        }
        CompanyEntity entity = new CompanyEntity();
        entity.setInfoId(homeDO.getInfoId());
        entity.setInfoType(ModuleEnum.getModuleEnum(homeDO.getInfoType()));
        entity.setH5Url(homeDO.getInfoUrl());
        entity.setInfoTitle(homeDO.getInfoTitle());
        entity.setInfoDescription(homeDO.getInfoDescription());
        entity.setInfoContent(homeDO.getInfoContent());

        entity.setRelationId(homeDO.getRelationId());
        return entity;
    }
}
