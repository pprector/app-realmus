package com.realmus.domain.service;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.common.util.ValidationUtil;
import com.realmus.domain.entity.ProductEntity;
import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.domain.repository.ProductRepository;
import com.realmus.facade.param.Product;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     * util
     * 获取所有产品信息分类
     *
     * @param languageEnum
     * @return
     */
    private List<ProductInfoEntity> getProductInfoAll(LanguageEnum languageEnum) {
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
     * 产品信息全部查询
     * 产品信息模糊(并分页查询)查询
     *
     * @param languageEnum
     * @param input
     * @return
     */
    public List<ProductInfoEntity> productSearch(LanguageEnum languageEnum, String input) {
        //查询全部产品信息
        List<ProductInfoEntity> productInfoEntityList = null;
        //全量查询信息
        productInfoEntityList = getProductInfoAll(languageEnum);
        if (StringUtils.isNotBlank(input)) {
            //数据过滤
            productInfoEntityList = dataFiltering(productInfoEntityList, input);
        }

        if (CollectionUtils.isEmpty(productInfoEntityList)) {
            throw new BizException(BizErrorEnum.B002);
        }

        return productInfoEntityList;
    }

    /**
     * 模糊查询过滤
     * 1. 先查询一级分类->存在直接返回此所有子数据 --> 否则第二步
     * 2. 先查询二级分类->存在直接更新一级分类下所有数据-->否则第三步
     * 3. 查询产品名称->存在保留->否则删除  -->看情况删除二级分类
     *
     * @param oldInfoEntityList
     * @return
     */
    private List<ProductInfoEntity> dataFiltering(List<ProductInfoEntity> oldInfoEntityList, String input) {
        if (CollectionUtils.isEmpty(oldInfoEntityList)) {
            return null;
        }
        List<ProductInfoEntity> newInfoEntityList = null;

        //如果一级菜单存在保留全部数据
        newInfoEntityList = oldInfoEntityList.stream().filter(productInfo -> productInfo.getProductName().contains(input)).collect(Collectors.toList());
        //过滤二级菜单
        for (ProductInfoEntity infoEntity : oldInfoEntityList) {
            if (newInfoEntityList.contains(infoEntity)) {
                break;
            }
            List<ProductInfoEntity> productInfoEntityListLv2 = infoEntity.getSonProductInfoList().stream().filter(productInfo -> productInfo.getProductName().contains(input)).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(productInfoEntityListLv2)) {
                infoEntity.setSonProductInfoList(productInfoEntityListLv2);
                newInfoEntityList.add(infoEntity);
                break;
            }
            //如果二级菜单也没有数据 遍历三级菜单
            List<ProductInfoEntity> productInfoEntityListLv2Not = infoEntity.getSonProductInfoList().stream().filter(productInfo ->
                            !(productInfo.getProductName().contains(input)))
                    .collect(Collectors.toList());
            //三级菜单
            List<ProductInfoEntity> productInfoEntityListLv3 = null;
            boolean isAddLv1ProductInfoEntity = false;
            List<ProductInfoEntity> removeList = new ArrayList<>();
            for (ProductInfoEntity productInfoEntityLv2 : productInfoEntityListLv2Not) {
                productInfoEntityListLv3 = productInfoEntityLv2.getSonProductInfoList().stream().filter(productInfo -> productInfo.getProductName().contains(input)).collect(Collectors.toList());
                if (CollectionUtils.isEmpty(productInfoEntityListLv3)) {
                    removeList.add(productInfoEntityLv2);  //这里会导致 遍历少一次
                } else {
                    productInfoEntityLv2.setSonProductInfoList(productInfoEntityListLv3);
                    isAddLv1ProductInfoEntity = true;
                }
            }
            //删除 没用的集合信息
            if (!CollectionUtils.isEmpty(removeList)) {
                productInfoEntityListLv2Not.removeAll(removeList);
                infoEntity.setSonProductInfoList(productInfoEntityListLv2Not);
            }
            if (isAddLv1ProductInfoEntity) newInfoEntityList.add(infoEntity);
        }

        return newInfoEntityList;

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

    /**
     * 产品信息新增或者修改
     *
     * @param languageEnum
     * @param input
     */
    public void productUpdate(LanguageEnum languageEnum, Product input) {
        ProductInfoEntity entity = productRepository.getProductInfoById(languageEnum, input.getProductId());
        if (input.getProductId() == null || entity == null || StringUtils.isBlank(entity.getProductId())){
            productRepository.addProduct(languageEnum, input);
        }else{
            productRepository.productInfoUpdate(languageEnum, input);
        }
    }

    public void productDelete(LanguageEnum languageEnum, String id) {
        productRepository.productInfoDelete(languageEnum, id);
    }
}
