package com.realmus.repository.mapper;

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
     * 根据名称查询数据
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
    List<ProductDO> productLikeSearch(@Param("input")String input);
}