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
     * 获取 所有产品父ID信息
     *
     * @return
     */
    List<ProductInfoEntity> getProductInfoParentList(LanguageEnum languageEnum);

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

    /**
     * 模糊查询产品数据
     *
     * @param languageEnum
     * @param input
     * @return
     */
    List<ProductInfoEntity> productSearch(LanguageEnum languageEnum, String input);
}
