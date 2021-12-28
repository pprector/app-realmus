package com.realmus.service.converter;

import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.facade.request.ProductExcel;

/**
 * @author hkpeng
 * @date 2021/12/24 - 15:49
 */

public class ProductFacadeConverter {

    public static ProductInfoEntity toProductEntity(Object obj) {
        if (obj == null) {
            return null;
        }
        ProductExcel productExcel = (ProductExcel) obj;

        ProductInfoEntity entity = new ProductInfoEntity();
        entity.setProductName(productExcel.getProductName());

        ProductInfoEntity lv1 = new ProductInfoEntity();
        lv1.setProductName(productExcel.getProductLv1Type());
        entity.setProductLv1(lv1);

        ProductInfoEntity lv2 = new ProductInfoEntity();
        lv2.setProductName(productExcel.getProductLv2Type());
        entity.setProductLv2(lv2);
        entity.setIngredient(productExcel.getIngredient());
        entity.setDescription(productExcel.getDescription());

        return entity;

    }
}
