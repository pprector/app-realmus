package com.realmus.domain.service;

import com.realmus.common.enums.LanguageEnum;
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
     * 根据 一级分类获取数据
     *
     * @param languageEnum
     * @param lv1Name
     * @return
     */
    public ProductInfoEntity getProductInfo(LanguageEnum languageEnum, String lv1Name) {
        //1. 获取ID
        ProductInfoEntity productLv1 = productRepository.getProductInfoIdByLv1Name(languageEnum, lv1Name);

        //2.获取二级分类
        List<ProductInfoEntity> productInfoLv2List = productRepository.getProductInfoLv2List(languageEnum, productLv1.getProductId());

        //3.填充二级分类数据
        productInfoLv2List = productRepository.fillProductInfoLv2List(languageEnum, productInfoLv2List);

        productLv1.setSonProductInfoList(productInfoLv2List);
        return productLv1;
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
}
