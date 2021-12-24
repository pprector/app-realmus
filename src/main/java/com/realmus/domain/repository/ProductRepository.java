package com.realmus.domain.repository;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.domain.entity.ProductEntity;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/24 - 16:17
 */

public interface ProductRepository {

    /**
     * 批量数据存储
     * @param languageEnum
     * @param entityList
     */
    void addProductList(LanguageEnum languageEnum, List<ProductEntity> entityList);
}
