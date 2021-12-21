package com.realmus.repository.mapper;

import com.realmus.repository.model.MultimediaDO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hkpeng
* @date 2021/12/21 - 11:26
*/
    
    
@Mapper
public interface CnMultimediaMapper {
    /**
     * delete by primary key
     * @param multimediaId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String multimediaId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(MultimediaDO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MultimediaDO record);

    /**
     * select by primary key
     * @param multimediaId primary key
     * @return object by primary key
     */
    MultimediaDO selectByPrimaryKey(String multimediaId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MultimediaDO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MultimediaDO record);
}