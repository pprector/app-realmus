package com.realmus.repository.mapper;

import com.realmus.domain.entity.ProductInfoEntity;
import com.realmus.repository.model.ProductDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/21 - 11:27
 */


@Mapper
public interface CnProductMapper {

    /**
     * 批量新增 产品信息
     *
     * @param productDOList
     */
    void insertProductDOList(@Param("productDOList") List<ProductDO> productDOList);

    /**
     * 根据名称批量删除
     *
     * @param productNameList
     */
    void deleteByNameList(@Param("productNameList") List<String> productNameList);

    /**
     * 获取顶级 产品分类信息
     *
     * @return
     */
    List<ProductDO> getProductInfoParentIdList();

    /**
     * 根据ID 获取二级分类
     *
     * @param productId
     * @return
     */
    List<ProductDO> getProductInfoIdByParentId(@Param("productId") String productId);

    /**
     * 模糊获取查询
     *
     * @param input
     * @return
     */
    List<ProductDO> productLikeSearch(@Param("input") String input);

    /**
     * 根据ID 获取信息
     *
     * @param productId
     * @return
     */
    ProductDO getProductInfoById(@Param("productId") String productId);

    /**
     * 更细信息
     * @param
     */
    void productInfoUpdate(ProductDO product);
}