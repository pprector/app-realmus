package com.realmus.service.converter;

import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.facade.request.ProductExcel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/24 - 15:49
 */

public class ProductFacadeConverter {

    public static List<ProductInfoEntity> toProductEntity(List<Object> objectList) {
        if (objectList == null) {
            return null;
        }
        List<ProductExcel> productExcelList = new ArrayList<>();
        for (Object obj : objectList) {
            productExcelList.add((ProductExcel) obj);
        }
        //取一级分类
        HashSet<String> lv1Type = new HashSet<>();
        for (ProductExcel productExcel : productExcelList) {
            lv1Type.add(productExcel.getProductLv1Type());
        }
        //遍历一级分类
        List<ProductInfoEntity> ProductInfoList = new ArrayList<>();
        for (String lv1Name : lv1Type) {
            ProductInfoEntity Lv1InfoEntity = new ProductInfoEntity();
            Lv1InfoEntity.setProductName(lv1Name);
            //填充二级分类
            List<ProductInfoEntity> son2ProductInfoList = new ArrayList<>();
            for (ProductExcel productExcel : productExcelList) {
                if (lv1Name.equals(productExcel.getProductLv1Type())) {
                    ProductInfoEntity productInfoEntity = new ProductInfoEntity();
                    productInfoEntity.setProductName(productExcel.getProductLv2Type());
                    //填充三级
                    List<ProductInfoEntity> son3ProductInfoList = new ArrayList<>();
                    for (ProductExcel productExcel3 : productExcelList) {
                        if (productExcel.getProductLv2Type().equals(productExcel3.getProductLv2Type())) {
                            ProductInfoEntity productInfoEntity3 = new ProductInfoEntity();
                            productInfoEntity3.setProductName(productExcel3.getProductName());
                            productInfoEntity3.setIngredient(productExcel3.getIngredient());
                            productInfoEntity3.setDescription(productExcel3.getDescription());
                            son3ProductInfoList.add(productInfoEntity3);
                        }
                    }
                    productInfoEntity.setSonProductInfoList(son3ProductInfoList);
                    son2ProductInfoList.add(productInfoEntity);
                }
            }
            Lv1InfoEntity.setSonProductInfoList(son2ProductInfoList);
            ProductInfoList.add(Lv1InfoEntity);
        }

        return ProductInfoList;

    }
}
