package com.realmus.repository.impl;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.domain.repository.ProductRepository;
import com.realmus.repository.converter.DoTOEntity;
import com.realmus.repository.converter.EntityToDo;
import com.realmus.repository.mapper.CnProductMapper;
import com.realmus.repository.model.NavigationDO;
import com.realmus.repository.model.ProductDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hkpeng
 * @date 2021/12/24 - 16:19
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private CnProductMapper cnProductMapper;


    @Override
    public void addProductList(LanguageEnum languageEnum, List<ProductInfoEntity> entityList) {
        //数据转换
        List<ProductDO> productDOList = EntityToDo.toProductDO(entityList);
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

    @Override
    public ProductInfoEntity getProductInfoIdByLv1Name(LanguageEnum languageEnum, String lv1Name) {
        ProductDO productDO = null;
        switch (languageEnum) {
            case CHINESE:
                productDO = cnProductMapper.getProductInfoIdByLv1Name(lv1Name);
                break;
            case ENGLISH:
                throw new BizException(BizErrorEnum.A001);
        }

        return DoTOEntity.toProductInfoEntity(productDO);
    }

    @Override
    public List<ProductInfoEntity> getProductInfoLv2List(LanguageEnum languageEnum, String productId) {
        List<ProductDO> productDOList = null;
        switch (languageEnum) {
            case CHINESE:
                productDOList = cnProductMapper.getProductInfoIdByParentId(productId);
                break;
            case ENGLISH:
                throw new BizException(BizErrorEnum.A001);
        }

        return productDOList.stream().sorted(Comparator.comparing(ProductDO::getProductWeight).reversed())
                .map(DoTOEntity::toProductInfoEntity).collect(Collectors.toList());
    }

    @Override
    public List<ProductInfoEntity> fillProductInfoLv2List(LanguageEnum languageEnum, List<ProductInfoEntity> productInfoLv2List) {

        for (ProductInfoEntity productInfoLv2Entity : productInfoLv2List) {
            List<ProductDO> productDOList = null;
            switch (languageEnum) {
                case CHINESE:
                    productDOList = cnProductMapper.getProductInfoIdByParentId(productInfoLv2Entity.getProductId());
                    break;
                case ENGLISH:
                    throw new BizException(BizErrorEnum.A001);
            }
            //产品集合
            List<ProductInfoEntity> productInfoEntityList = productDOList.stream()
                    .map(DoTOEntity::toProductInfoEntity).limit(5).collect(Collectors.toList());

            productInfoLv2Entity.setSonProductInfoList(productInfoEntityList);
        }

        return productInfoLv2List;
    }
}
