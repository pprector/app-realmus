package com.realmus.domain.service;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.domain.entity.ProductEntity;
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


    public void addProductList(LanguageEnum languageEnum, List<ProductEntity> entityList) {
        logger.info("=====ProductService addProductList request : " + entityList);
        productRepository.addProductList(languageEnum, entityList);
    }
}
