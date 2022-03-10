package com.realmus.repository.mapper;

import com.realmus.repository.model.InformDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hkpeng
 * @date 2022/3/9 - 15:08
 */


@Mapper
public interface InformMapper {
    int deleteByPrimaryKey(String informId);

    int insert(InformDO record);

    int insertSelective(InformDO record);

    InformDO selectByPrimaryKey(String informId);

    int updateByPrimaryKeySelective(InformDO record);

    int updateByPrimaryKey(InformDO record);
}