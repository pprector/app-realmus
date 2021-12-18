package com.realmus.domain.repository;

import com.realmus.domain.entity.UserEntity;

/**
 * @author hkpeng
 * @date 2021/12/18 - 15:17
 */

public interface UserRepository {

    long addUser(UserEntity entity);
}
