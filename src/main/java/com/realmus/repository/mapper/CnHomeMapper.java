package com.realmus.repository.mapper;

import com.realmus.repository.model.HomeDO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hkpeng
* @date 2021/12/21 - 11:25
*/
    
    
@Mapper
public interface CnHomeMapper {
    /**
     * delete by primary key
     * @param infoId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String infoId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(HomeDO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(HomeDO record);

    /**
     * select by primary key
     * @param infoId primary key
     * @return object by primary key
     */
    HomeDO selectByPrimaryKey(String infoId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(HomeDO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(HomeDO record);
}