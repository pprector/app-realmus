package com.realmus.repository.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.realmus.common.enums.GeneralEnum;
import com.realmus.common.util.IdWorker;
import com.realmus.domain.entity.InformEntity;
import com.realmus.domain.entity.MultimediaEntity;
import com.realmus.domain.entity.NavigationEntity;
import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.facade.param.Product;
import com.realmus.repository.model.InformDO;
import com.realmus.repository.model.NavigationDO;
import com.realmus.repository.model.ProductDO;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/24 - 16:21
 */

public class EntityToDo {
    private static final Integer productWeight = 100;

    public static List<ProductDO> toProductDOList(List<ProductInfoEntity> entityList) {

        if (entityList == null) {
            return null;
        }
        List<ProductDO> productDOList = new ArrayList<>();

        for (ProductInfoEntity entity : entityList) {
            ProductDO productDO = new ProductDO();
            productDO.setProductId(IdWorker.getNextId());
            productDO.setProductName(entity.getProductName());
            productDO.setProductWeight(productWeight);
            productDO.setParentId("0");
            productDO.setIsValid(1);
            productDO.setModifier("phk");
            productDO.setGmtModified(new Date());
            for (ProductInfoEntity sonEntity : entity.getSonProductInfoList()) {
                ProductDO sonProductDO = new ProductDO();
                sonProductDO.setProductId(IdWorker.getNextId());
                sonProductDO.setProductName(sonEntity.getProductName());
                sonProductDO.setProductWeight(productWeight);
                sonProductDO.setParentId(productDO.getProductId());
                sonProductDO.setIsValid(1);
                sonProductDO.setModifier("phk");
                sonProductDO.setGmtModified(new Date());
                for (ProductInfoEntity infoEntity : sonEntity.getSonProductInfoList()) {
                    ProductDO productInfoDO = new ProductDO();
                    productInfoDO.setProductId(IdWorker.getNextId());
                    productInfoDO.setProductName(infoEntity.getProductName());
                    productInfoDO.setProductWeight(productWeight);
                    productInfoDO.setParentId(sonProductDO.getProductId());
                    productInfoDO.setProductIngredient(infoEntity.getIngredient());
                    productInfoDO.setProductDescribe(infoEntity.getDescription());
                    productInfoDO.setIsValid(1);
                    productInfoDO.setModifier("phk");
                    productInfoDO.setGmtModified(new Date());
                    productDOList.add(productInfoDO);
                }
                productDOList.add(sonProductDO);
            }
            productDOList.add(productDO);
        }

        return productDOList;

    }

    public static NavigationDO toNavigationDO(NavigationEntity entity) {
        if (entity == null) {
            return null;
        }
        NavigationDO navigationDO = new NavigationDO();
        navigationDO.setNavigationId(entity.getNavigationId());
        navigationDO.setNavigationName(entity.getNavigationName());
        navigationDO.setNavigationUrl(entity.getH5Url());
        navigationDO.setExtendJson(JSONObject.toJSONString(entity.getExtension()));
        navigationDO.setNavigationTier(entity.getNavigationTier());
        navigationDO.setNavigationParentId(entity.getNavigationParentId());
        navigationDO.setWeight(entity.getWeight());
        navigationDO.setIsValid(GeneralEnum.YES.getCode());
        navigationDO.setModifier("phk");
        navigationDO.setGmtModified(new Date());
        return navigationDO;
    }

    public static ProductDO toProductDO(ProductInfoEntity productInfo) {
        ProductDO productInfoDO = new ProductDO();
        productInfoDO.setProductId(productInfo.getProductId());
        productInfoDO.setProductName(productInfo.getProductName());
        productInfoDO.setProductIngredient(productInfo.getIngredient());
        productInfoDO.setProductDescribe(productInfo.getDescription());
        productInfoDO.setExtendJson(JSONObject.toJSONString(productInfo.getMultimedia()));
        productInfoDO.setGmtModified(new Date());

        return productInfoDO;
    }

    public static ProductDO toProductDO(Product product) {
        ProductDO productInfoDO = new ProductDO();
        if (StringUtils.isBlank(product.getProductId())){
            productInfoDO.setProductId(IdWorker.getNextId());
        }else {
            productInfoDO.setProductId(product.getProductId());
        }
        if (StringUtils.isBlank(product.getProductParentId())){
            productInfoDO.setProductId("0");
        }else{
            productInfoDO.setParentId(product.getProductParentId());
        }

        productInfoDO.setProductName(product.getProductName());
        productInfoDO.setProductIngredient(product.getIngredient());
        productInfoDO.setProductDescribe(product.getDescription());
        productInfoDO.setGmtModified(new Date());
        productInfoDO.setModifier("phk");
        productInfoDO.setProductWeight(100);
        productInfoDO.setIsValid(1);

        return productInfoDO;
    }

    /**
     * 表单DO转换信息
     *
     * @param entity
     * @return
     */
    public static InformDO toInformDO(InformEntity entity) {
        if (entity == null) {
            return null;
        }
        InformDO informDO = new InformDO();
        informDO.setInformId(IdWorker.getNextId());
        informDO.setName(entity.getName());
        informDO.setCompanyName(entity.getCompanyName());
        informDO.setEmaliCode(entity.getEmail());
        informDO.setPhoneCode(entity.getPhone());
        informDO.setInformMessage(entity.getMessage());
        if (entity.getFollowUpEntity() != null) {
            informDO.setMerchandiser(entity.getFollowUpEntity().getMerchandiser());
            informDO.setRemarks(entity.getFollowUpEntity().getRemarks());
        }
        informDO.setIsValid(1);
        informDO.setModifier("phk");
        informDO.setGmtModified(new Date());

        return informDO;
    }
}
