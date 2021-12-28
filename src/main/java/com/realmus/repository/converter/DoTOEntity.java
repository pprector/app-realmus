package com.realmus.repository.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.realmus.common.enums.ExtendTypeEnum;
import com.realmus.common.enums.ModuleEnum;
import com.realmus.common.enums.MultimediaEnum;
import com.realmus.domain.entity.*;
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

    public static ExtensionEntity toExtensionEntity(NavigationDO navigationDO) {
        if (navigationDO == null) {
            return null;
        }
        ExtensionEntity entity = new ExtensionEntity();
        entity.setExtendId(navigationDO.getNavigationId());
        ExtendTypeEnum extendTypeEnum = ExtendTypeEnum.getLanguageEnum(navigationDO.getNavigationId());
        entity.setExtendType(extendTypeEnum);

        String extendJson = navigationDO.getExtendJson();
        switch (extendTypeEnum) {
            case HOME_INFO:
                HomeInfoEntity homeInfoEntity = JSONObject.parseObject(extendJson, HomeInfoEntity.class);
                entity.setExtension(homeInfoEntity);
                break;
            case ABOUT_US:
                AboutUsEntity aboutUsEntity = JSONObject.parseObject(extendJson, AboutUsEntity.class);
                entity.setExtension(aboutUsEntity);
                break;
        }
        return entity;
    }


    public static MultimediaEntity toMultimediaEntity(String relationId, MultimediaDO multimediaDO) {
        if (multimediaDO == null) {
            return null;
        }
        MultimediaEntity entity = new MultimediaEntity();
        entity.setMultimediaType(MultimediaEnum.getMultimediaEnum(multimediaDO.getMultimediaType()));
        entity.setMultimediaUrl(multimediaDO.getMultimediaUrl());
        entity.setDescription(multimediaDO.getMultimediaDesc());
        return entity;
    }


}
