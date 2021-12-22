package com.realmus.repository.mapper;

import com.realmus.repository.model.MultimediaRelationDO;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hkpeng
* @date 2021/12/21 - 11:26
*/
    
    
@Mapper
public interface MultimediaRelationMapper {
    /**
     * delete by primary key
     * @param relationId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String relationId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(MultimediaRelationDO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MultimediaRelationDO record);

    /**
     * select by primary key
     * @param relationId primary key
     * @return object by primary key
     */
    MultimediaRelationDO selectByPrimaryKey(String relationId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MultimediaRelationDO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MultimediaRelationDO record);
}