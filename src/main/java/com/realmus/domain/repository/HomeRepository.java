package com.realmus.domain.repository;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.domain.entity.AboutUsEntity;
import com.realmus.domain.entity.HomeInfoEntity;
import com.realmus.domain.entity.NavigationEntity;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/22 - 14:45
 */

public interface HomeRepository {
    /**
     * 获取Home 信息
     *
     * @return
     */
    HomeInfoEntity getHomeInfoChinese(LanguageEnum languageEnum);

    /**
     * 获取关于我们信息
     * @param languageEnum
     * @return
     */
    AboutUsEntity getAboutUsInfo(LanguageEnum languageEnum);
}
