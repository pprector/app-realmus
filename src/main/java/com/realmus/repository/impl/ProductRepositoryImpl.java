package com.realmus.repository.impl;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.domain.repository.ProductRepository;
import com.realmus.repository.converter.DoTOEntity;
import com.realmus.repository.converter.EntityToDo;
import com.realmus.repository.mapper.CnProductMapper;
import com.realmus.repository.mapper.EnProductMapper;
import com.realmus.repository.model.ProductDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

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

    @Autowired
    private EnProductMapper enProductMapper;


    @Override
    public void addProductList(LanguageEnum languageEnum, List<ProductInfoEntity> entityList) {
        //数据转换
        List<ProductDO> productDOList = EntityToDo.toProductDOList(entityList);
        //提取产品名称   删除
        List<String> productNameList = productDOList.stream().map(ProductDO::getProductName).collect(Collectors.toList());


        switch (languageEnum) {
            case CHINESE:
                cnProductMapper.deleteByNameList(productNameList);
                cnProductMapper.insertProductDOList(productDOList);
                break;
            case ENGLISH:
                enProductMapper.deleteByNameList(productNameList);
                enProductMapper.insertProductDOList(productDOList);
        }
    }

    @Override
    public List<ProductInfoEntity> getProductInfoParentList(LanguageEnum languageEnum) {
        //父ID值
        List<ProductDO> productDOList = null;
        switch (languageEnum) {
            case CHINESE:
                productDOList = cnProductMapper.getProductInfoParentIdList();
                break;
            case ENGLISH:
                productDOList = enProductMapper.getProductInfoParentIdList();
                break;
        }

        return productDOList.stream()
                .map(DoTOEntity::toProductInfoEntity).collect(Collectors.toList());
    }

    @Override
    public List<ProductInfoEntity> getProductInfoLv2List(LanguageEnum languageEnum, String productId) {
        List<ProductDO> productDOList = null;
        switch (languageEnum) {
            case CHINESE:
                productDOList = cnProductMapper.getProductInfoIdByParentId(productId);
                break;
            case ENGLISH:
                productDOList = enProductMapper.getProductInfoIdByParentId(productId);
                break;
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
                    productDOList = enProductMapper.getProductInfoIdByParentId(productInfoLv2Entity.getProductId());
                    break;
            }
            //产品集合
            List<ProductInfoEntity> productInfoEntityList = productDOList.stream()
                    .map(DoTOEntity::toProductInfoEntity).collect(Collectors.toList());

            productInfoLv2Entity.setSonProductInfoList(productInfoEntityList);
        }

        return productInfoLv2List;
    }


    @Override
    public ProductInfoEntity getProductInfoById(LanguageEnum language, String productId) {
        ProductDO product = null;
        switch (language) {
            case CHINESE:
                product = cnProductMapper.getProductInfoById(productId);
                break;
            case ENGLISH:
                product = enProductMapper.getProductInfoById(productId);
                break;
        }
        //数据封装处理
        return DoTOEntity.toProductInfoEntity(product);
    }

    @Override
    public void productInfoUpdate(LanguageEnum language, ProductInfoEntity productInfo) {

        ProductDO product = EntityToDo.toProductDO(productInfo);
        switch (language) {
            case CHINESE:
                cnProductMapper.productInfoUpdate(product);
                break;
            case ENGLISH:
                enProductMapper.productInfoUpdate(product);
                break;
        }
    }

}
