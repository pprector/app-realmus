package com.realmus.domain.service;

import com.realmus.common.enums.ExtendTypeEnum;
import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.domain.entity.AboutUsEntity;
import com.realmus.domain.entity.ExtensionEntity;
import com.realmus.domain.entity.HomeInfoEntity;
import com.realmus.domain.entity.NavigationEntity;
import com.realmus.domain.repository.NavigationRepository;
import com.realmus.repository.model.NavigationDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/21 - 10:52
 */

@Service
public class NavigationService {
    private static final Logger logger = LoggerFactory.getLogger(NavigationService.class);

    @Autowired
    private NavigationRepository navigationRepository;

    /**
     * 查询导航栏
     *
     * @return
     */
    public List<NavigationEntity> getNavigationInfo(LanguageEnum languageEnum) {
        logger.info("=====NavigationService getNavigationInfo request : ");
        //查询出所有数据
        List<NavigationEntity> navigationEntityList = navigationRepository.getNavigationChineseInfo(languageEnum);
        return navigationEntityList;
    }

    /**
     * 获取首页信息
     *
     * @param languageEnum
     * @return
     */
    public HomeInfoEntity getHomeInfo(LanguageEnum languageEnum) {

        ExtensionEntity<HomeInfoEntity> extendInfo = navigationRepository.findExtendInfo(languageEnum, ExtendTypeEnum.HOME_INFO.getId());
        HomeInfoEntity homeInfoEntity = extendInfo.getExtension();
        return homeInfoEntity;
    }

    /**
     * 获取关于我们信息
     *
     * @param languageEnum
     * @return
     */
    public AboutUsEntity getAboutUsInfo(LanguageEnum languageEnum) {
        ExtensionEntity<AboutUsEntity> extendInfo = navigationRepository.findExtendInfo(languageEnum, ExtendTypeEnum.ABOUT_US.getId());
        AboutUsEntity homeInfoEntity = extendInfo.getExtension();
        return homeInfoEntity;

    }
}
