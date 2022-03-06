package com.realmus.domain.service;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.domain.entity.ProductEntity;
import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.domain.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/24 - 16:14
 */
@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;


    public void addProductList(LanguageEnum languageEnum, List<ProductInfoEntity> entityList) {
        logger.info("=====ProductService addProductList request : " + entityList);
        productRepository.addProductList(languageEnum, entityList);
    }

    /**
     * 根据 获取所有产品信息分类
     *
     * @param languageEnum
     * @return
     */
    public List<ProductInfoEntity> getProductInfoAll(LanguageEnum languageEnum) {
        //1. 获取ID
        List<ProductInfoEntity> productInfoParentIdList = productRepository.getProductInfoParentList(languageEnum);

        for (ProductInfoEntity productInfoEntity : productInfoParentIdList) {
            //2.获取二级分类
            List<ProductInfoEntity> productInfoLv2List = productRepository.getProductInfoLv2List(languageEnum, productInfoEntity.getProductId());

            //3.填充二级分类数据
            productInfoLv2List = productRepository.fillProductInfoLv2List(languageEnum, productInfoLv2List);

            productInfoEntity.setSonProductInfoList(productInfoLv2List);
        }

        return productInfoParentIdList;
    }

    /**
     * 产品信息模糊(并分页查询)查询
     *
     * @param languageEnum
     * @param input
     * @return
     */
    public List<ProductInfoEntity> productSearch(LanguageEnum languageEnum, String input) {
        List<ProductInfoEntity> productInfoEntityList = productRepository.productSearch(languageEnum, input);

        return null;
    }

    /**
     * 根据 产品ID 获取信息
     *
     * @param language
     * @param productId
     * @return
     */
    public ProductInfoEntity getProductInfoById(LanguageEnum language, String productId) {
        logger.info("=====ProductService getProductInfoById request : " + productId);
        return productRepository.getProductInfoById(language, productId);


    }

    /**
     * 更新产品信息
     *
     * @param productInfo
     */
    public void productInfoUpdate(LanguageEnum language, ProductInfoEntity productInfo) {
        logger.info("=====ProductService getProductInfoById request : " + productInfo);
        productRepository.productInfoUpdate(language, productInfo);
    }
}
