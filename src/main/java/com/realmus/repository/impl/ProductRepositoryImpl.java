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
        List<ProductDO> productDOList = EntityToDo.toProductDO(entityList);
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
                    .map(DoTOEntity::toProductInfoEntity).limit(10).collect(Collectors.toList());

            productInfoLv2Entity.setSonProductInfoList(productInfoEntityList);
        }

        return productInfoLv2List;
    }

    @Override
    public List<ProductInfoEntity> productSearch(LanguageEnum languageEnum, String input) {
        List<ProductDO> productDOList = null;
        switch (languageEnum) {
            case CHINESE:
                productDOList = cnProductMapper.productLikeSearch(input);
                break;
            case ENGLISH:
                productDOList = enProductMapper.productLikeSearch(input);
                break;
        }
        //数据封装处理

        return dataEncapsulation(productDOList);
    }

    /**
     * 产品数据处理处理规则如下:
     * 1.保证一级分类的顺序
     * 2.一级分类下保证二级分类的顺序
     * 3.二级分类下保证最佳匹配顺序
     * 4.每个大分类一个集合
     *
     * @return
     */
    private List<ProductInfoEntity> dataEncapsulation(List<ProductDO> productDOList) {

        return null;
    }
}
