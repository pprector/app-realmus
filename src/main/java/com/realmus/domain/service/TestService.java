package com.realmus.domain.service;

import com.realmus.domain.entity.UserEntity;
import com.realmus.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author hkpeng
 * @date 2021/12/18 - 16:15
 */

@Service("testService")
public class TestService {
    @Autowired
    private UserRepository userRepository;


    public long addUser(UserEntity entity) {
        return userRepository.addUser(entity);
    }
}
