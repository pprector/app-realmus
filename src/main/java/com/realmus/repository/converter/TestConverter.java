package com.realmus.repository.converter;


import com.realmus.domain.entity.UserEntity;
import com.realmus.facade.request.User;
import com.realmus.repository.model.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


/**
 * @author hkpeng
 * @date 2021/12/18 - 14:46
 */

@Mapper
public interface TestConverter {

    @Mapping(target = "name", source = "userName")
    @Mapping(target = "id", source = "userId")
    Test toTest(UserEntity user);
}
