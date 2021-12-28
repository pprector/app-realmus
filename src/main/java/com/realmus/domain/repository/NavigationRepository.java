package com.realmus.domain.repository;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.domain.entity.NavigationEntity;

import java.util.List;

/**
 * @author hkpeng
 * 导航栏操作
 * @date 2021/12/21 - 11:27
 */

public interface NavigationRepository {

    /**
     * 查询导航栏
     *
     * @return
     */
    List<NavigationEntity> getNavigationChineseInfo(LanguageEnum languageEnum);


    /**
     * 查询扩展信息
     *
     * @return
     */
    NavigationEntity findExtendInfo(LanguageEnum languageEnum, String navigationId);

    /**
     * 更新 导航数据
     *
     * @param navigation
     */
    void updateNavigationInfo(LanguageEnum languageEnum,NavigationEntity navigation);
}
