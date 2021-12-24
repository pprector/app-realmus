package com.realmus.service.converter;

import com.realmus.domain.entity.ProductEntity;
import com.realmus.facade.request.ProductExcel;

/**
 * @author hkpeng
 * @date 2021/12/24 - 15:49
 */

public class ProductFacadeConverter {

    public static ProductEntity toProductEntity(Object obj) {
        if (obj == null) {
            return null;
        }
        ProductExcel productExcel = (ProductExcel) obj;

        ProductEntity entity = new ProductEntity();
        entity.setProductName(productExcel.getProductName());

        ProductEntity lv1 = new ProductEntity();
        lv1.setProductName(productExcel.getProductLv1Type());
        entity.setProductLv1(lv1);

        ProductEntity lv2 = new ProductEntity();
        lv2.setProductName(productExcel.getProductLv2Type());
        entity.setProductLv2(lv2);
        entity.setIngredient(productExcel.getIngredient());
        entity.setDescription(productExcel.getDescription());

        return entity;

    }
}
