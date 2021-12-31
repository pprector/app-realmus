package com.realmus.domain.repository;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.domain.entity.ProductInfoEntity;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/24 - 16:17
 */

public interface ProductRepository {

    /**
     * 批量数据存储
     *
     * @param languageEnum
     * @param entityList
     */
    void addProductList(LanguageEnum languageEnum, List<ProductInfoEntity> entityList);

    /**
     * 根据名称获取 一级分类 实体
     *
     * @param lv1Name
     * @return
     */
    ProductInfoEntity getProductInfoIdByLv1Name(LanguageEnum languageEnum, String lv1Name);

    /**
     * 根据Id  查询对应的子分类
     *
     * @param productId
     * @return
     */
    List<ProductInfoEntity> getProductInfoLv2List(LanguageEnum languageEnum, String productId);

    /**
     * 填充二级分类对应产品信息  最多10条
     *
     * @param languageEnum
     * @param productInfoLv2List
     * @return
     */
    List<ProductInfoEntity> fillProductInfoLv2List(LanguageEnum languageEnum, List<ProductInfoEntity> productInfoLv2List);
}
