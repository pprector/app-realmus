package com.realmus.repository.impl;

import com.realmus.domain.entity.UserEntity;
import com.realmus.domain.repository.UserRepository;
import com.realmus.repository.converter.TestConverter;
import com.realmus.repository.mapper.TestMapper;

import com.realmus.repository.model.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author hkpeng
 * @date 2021/12/18 - 16:17
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final TestConverter mapper = Mappers.getMapper(TestConverter.class);
    @Autowired
    private TestMapper testMapper;


    @Override
    public long addUser(UserEntity entity) {

        Test test = mapper.toTest(entity);
        int insert = 0;
        try {
            insert = testMapper.insert(test);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return insert;
    }
}
