package com.realmus.repository.mapper;

import com.realmus.repository.model.NavigationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author hkpeng
* @date 2021/12/21 - 11:27
*/
    
    
@Mapper
public interface CnNavigationMapper {
    /**
     * delete by primary key
     * @param navigationId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String navigationId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(NavigationDO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(NavigationDO record);

    /**
     * select by primary key
     * @param navigationId primary key
     * @return object by primary key
     */
    NavigationDO selectByPrimaryKey(String navigationId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(NavigationDO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(NavigationDO record);

    /**
     * 查询所有数据
     * @return
     */
    List<NavigationDO> findAllNavigationInfo();
}