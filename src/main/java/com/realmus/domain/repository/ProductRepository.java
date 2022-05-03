package com.realmus.domain.repository;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.domain.entity.ProductEntity;
import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.facade.param.Product;

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
     * 根据ID 获取产品信息
     *
     * @param language
     * @param productId
     * @return
     */
    ProductInfoEntity getProductInfoById(LanguageEnum language, String productId);

    /**
     * 更细产品信息
     * @param language
     * @param productInfo
     */
    void productInfoUpdate(LanguageEnum language, ProductInfoEntity productInfo);

    /**
     * 更细产品信息
     * @param language
     * @param productInfo
     */
    void productInfoUpdate(LanguageEnum language, Product product);

    /**
     * 产品信息新增
     * @param languageEnum
     * @param input
     */
    void addProduct(LanguageEnum languageEnum, Product input);
    /**
     * 删除产品
     * @param languageEnum
     * @param id
     */
    void productInfoDelete(LanguageEnum languageEnum, String id);
}
