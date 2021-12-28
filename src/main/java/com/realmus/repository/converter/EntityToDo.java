package com.realmus.repository.converter;

import com.alibaba.fastjson.JSONObject;
import com.realmus.common.enums.GeneralEnum;
import com.realmus.common.util.IdWorker;
import com.realmus.domain.entity.NavigationEntity;
import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.repository.model.NavigationDO;
import com.realmus.repository.model.ProductDO;

import java.util.Date;

/**
 * @author hkpeng
 * @date 2021/12/24 - 16:21
 */

public class EntityToDo {
    private static final Integer productWeight = 100;

    public static ProductDO toProductDO(ProductInfoEntity entity) {

        if (entity == null) {
            return null;
        }
        ProductDO productDO = new ProductDO();
        productDO.setProductId(IdWorker.getNextId());
        if (entity.getProductLv1() != null) {
            productDO.setProductLv1type(entity.getProductLv1().getProductName());
        }
        if (entity.getProductLv2() != null) {
            productDO.setProductLv2type(entity.getProductLv2().getProductName());
        }
        productDO.setProductName(entity.getProductName());
        productDO.setProductIngredient(entity.getIngredient());
        productDO.setProductDescribe(entity.getDescription());
        productDO.setProductWeight(productWeight);
        productDO.setIsValid(1);
        productDO.setModifier("phk");
        productDO.setGmtModified(new Date());


        return productDO;

    }

    public static NavigationDO toNavigationDO(NavigationEntity entity) {
        if (entity == null) {
            return null;
        }
        NavigationDO navigationDO = new NavigationDO();
        navigationDO.setNavigationId(entity.getNavigationId());
        navigationDO.setNavigationName(entity.getNavigationName());
        navigationDO.setNavigationUrl(entity.getH5Url());
        navigationDO.setExtendJson(JSONObject.toJSONString(entity.getExtension()));
        navigationDO.setNavigationTier(entity.getNavigationTier());
        navigationDO.setNavigationParentId(entity.getNavigationParentId());
        navigationDO.setWeight(entity.getWeight());
        navigationDO.setIsValid(GeneralEnum.YES.getCode());
        navigationDO.setModifier("phk");
        navigationDO.setGmtModified(new Date());
        return navigationDO;
    }
}
