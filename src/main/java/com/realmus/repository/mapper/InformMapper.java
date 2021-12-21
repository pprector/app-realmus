package com.realmus.repository.mapper;

import com.realmus.repository.model.InformDO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hkpeng
* @date 2021/12/21 - 11:27
*/
    
    
@Mapper
public interface InformMapper {
    /**
     * delete by primary key
     * @param informId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String informId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(InformDO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(InformDO record);

    /**
     * select by primary key
     * @param informId primary key
     * @return object by primary key
     */
    InformDO selectByPrimaryKey(String informId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(InformDO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(InformDO record);
}