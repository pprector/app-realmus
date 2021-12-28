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
import org.apache.commons.lang.StringUtils;

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
        if (StringUtils.isNotEmpty(navigationDO.getExtendJson())) {
            //扩展信息 封装
            return toExtensionNavigationEntity(entity, navigationDO.getExtendJson());
        } else {
            return entity;
        }

    }

    private static NavigationEntity toExtensionNavigationEntity(NavigationEntity entity, String extendJson) {
        if (entity == null) {
            return null;
        }
        ExtendTypeEnum extendTypeEnum = ExtendTypeEnum.getLanguageEnum(entity.getNavigationId());

        switch (extendTypeEnum) {
            case HOME_INFO:
                HomeInfoEntity homeInfoEntity = JSONObject.parseObject(extendJson, HomeInfoEntity.class);
                entity.setExtension(homeInfoEntity);
                break;
            case ABOUT_US:
                AboutUsEntity aboutUsEntity = JSONObject.parseObject(extendJson, AboutUsEntity.class);
                entity.setExtension(aboutUsEntity);
                break;
            case NEWS:
                NewsEntity newsEntity = JSONObject.parseObject(extendJson, NewsEntity.class);
                entity.setExtension(newsEntity);
                break;
            case RD:
                RDEntity rdEntity = JSONObject.parseObject(extendJson, RDEntity.class);
                entity.setExtension(rdEntity);
                break;
            case PRODUCT:
                ProductEntity productEntity = JSONObject.parseObject(extendJson, ProductEntity.class);
                entity.setExtension(productEntity);
                break;
            case BRAND:
                BrandEntity brandEntity = JSONObject.parseObject(extendJson, BrandEntity.class);
                entity.setExtension(brandEntity);
                break;
            case FOREIGN:
                ForeignEntity foreignEntity = JSONObject.parseObject(extendJson, ForeignEntity.class);
                entity.setExtension(foreignEntity);
                break;
            case CONTACT_US:
                ContactUsEntity contactUsEntity = JSONObject.parseObject(extendJson, ContactUsEntity.class);
                entity.setExtension(contactUsEntity);
                break;

        }
        return entity;
    }


}
