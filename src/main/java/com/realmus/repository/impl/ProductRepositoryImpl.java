package com.realmus.repository.impl;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.domain.entity.ProductEntity;
import com.realmus.domain.repository.ProductRepository;
import com.realmus.repository.converter.EntityToDo;
import com.realmus.repository.mapper.CnProductMapper;
import com.realmus.repository.model.ProductDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hkpeng
 * @date 2021/12/24 - 16:19
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private CnProductMapper cnProductMapper;


    @Override
    public void addProductList(LanguageEnum languageEnum, List<ProductEntity> entityList) {
        //数据转换
        List<ProductDO> productDOList = entityList.stream().map(EntityToDo::toProductDO).collect(Collectors.toList());
        //提取产品名称   删除
        List<String> productNameList = productDOList.stream().map(ProductDO::getProductName).collect(Collectors.toList());


        switch (languageEnum) {
            case CHINESE:
                cnProductMapper.deleteByNameList(productNameList);
                cnProductMapper.insertProductDOList(productDOList);
                break;
            case ENGLISH:
                throw new BizException(BizErrorEnum.A001);
        }
    }
}
