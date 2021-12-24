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
    void insertProductDOList(@Param("productDOList")List<ProductDO> productDOList);

    /**
     * 根据名称批量删除
     * @param productNameList
     */
    void deleteByNameList(@Param("productNameList") List<String> productNameList);
}