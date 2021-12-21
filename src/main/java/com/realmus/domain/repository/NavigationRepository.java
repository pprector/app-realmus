package com.realmus.domain.repository;

import com.realmus.domain.entity.NavigationEntity;

import java.util.List;

/**
 * @author hkpeng
 * 导航栏操作
 * @date 2021/12/21 - 11:27
 */

public interface NavigationRepository {
    List<NavigationEntity> getNavigationInfo();
}
