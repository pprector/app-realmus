package com.realmus.repository.converter;

import com.realmus.common.util.IdWorker;
import com.realmus.domain.entity.ProductEntity;
import com.realmus.repository.model.ProductDO;

import java.util.Date;

/**
 * @author hkpeng
 * @date 2021/12/24 - 16:21
 */

public class EntityToDo {
    private static final Integer productWeight = 100;

    public static ProductDO toProductDO(ProductEntity entity) {

        if (entity == null) {
            return null;
        }
        ProductDO productDO = new ProductDO();
        productDO.setProductId(IdWorker.getNextId());
        if (entity.getProductLv1() != null) {
            productDO.setProductLv1type(entity.getProductLv1().getProductName());
            if (entity.getProductLv1().getMultimedia() != null) {
                productDO.setProductLv1RelationId(entity.getProductLv1().getMultimedia().getRelationId());
            }
        }
        if (entity.getProductLv2() != null) {
            productDO.setProductLv2type(entity.getProductLv2().getProductName());
            if (entity.getProductLv2().getMultimedia() != null) {
                productDO.setProductLv2RelationId(entity.getProductLv2().getMultimedia().getRelationId());
            }
        }
        productDO.setProductName(entity.getProductName());
        productDO.setProductIngredient(entity.getIngredient());
        productDO.setProductDescribe(entity.getDescription());
        productDO.setProductWeight(productWeight);
        if (entity.getMultimedia() != null) {
            productDO.setProductRelationId(entity.getMultimedia().getRelationId());
        }
        productDO.setIsValid(1);
        productDO.setModifier("phk");
        productDO.setGmtModified(new Date());


        return productDO;

    }
}
