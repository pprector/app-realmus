package com.realmus.repository.mapper;

import com.realmus.repository.model.ProductDO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hkpeng
* @date 2021/12/21 - 11:27
*/
    
    
@Mapper
public interface CnProductMapper {
    /**
     * delete by primary key
     * @param productId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String productId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(ProductDO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ProductDO record);

    /**
     * select by primary key
     * @param productId primary key
     * @return object by primary key
     */
    ProductDO selectByPrimaryKey(String productId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ProductDO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ProductDO record);
}