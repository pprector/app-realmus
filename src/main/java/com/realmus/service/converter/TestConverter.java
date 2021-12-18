package com.realmus.service.converter;


import com.realmus.domain.entity.UserEntity;
import com.realmus.facade.request.User;
import org.mapstruct.Mapper;


/**
 * @author hkpeng
 * @date 2021/12/18 - 14:46
 */

@Mapper
public interface TestConverter {

    UserEntity TestTOUserEntity(User user);
}
