package com.realmus.repository.mapper;

import com.realmus.repository.model.MultimediaDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author hkpeng
* @date 2021/12/21 - 11:26
*/
    
    
@Mapper
public interface MultimediaMapper {
    /**
     * 根据关联Id 获取媒体信息ID
     * @param relationId
     * @return
     */
    MultimediaDO getMultimediaEntityOne(@Param("relationId") String relationId);
}