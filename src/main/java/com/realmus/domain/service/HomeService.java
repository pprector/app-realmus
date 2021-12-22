package com.realmus.domain.service;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.domain.entity.BannerEntity;
import com.realmus.domain.entity.HomeInfoEntity;
import com.realmus.domain.entity.MultimediaEntity;
import com.realmus.domain.entity.NavigationEntity;
import com.realmus.domain.repository.HomeRepository;
import com.realmus.domain.repository.MultimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/22 - 14:16
 */
@Service
public class HomeService {

    private static final Logger logger = LoggerFactory.getLogger(HomeService.class);

    @Autowired
    private HomeRepository homeRepository;
    @Autowired
    private MultimediaRepository multimediaRepository;

    /**
     * 获取 Home  数据
     *
     * @return
     */
    public HomeInfoEntity getHomeInfo(LanguageEnum languageEnum) {
        logger.info("=====HomeService getHomeInfo request : " + languageEnum);
        //查询出所有Home 数据
        HomeInfoEntity homeInfoEntity = homeRepository.getHomeInfoChinese(languageEnum);
        //填充所有媒体信息

        return fillMultimediaInfo(homeInfoEntity);
    }

    private HomeInfoEntity fillMultimediaInfo(HomeInfoEntity homeInfoEntity) {
        //1.填充轮播图媒体
        List<BannerEntity> bannerList = homeInfoEntity.getBannerList();
        for (BannerEntity bannerEntity : bannerList) {
            if (bannerEntity.getMultimedia() == null) {
                continue;
            }
            MultimediaEntity multimediaEntityOne = multimediaRepository.getMultimediaEntityOne(bannerEntity.getMultimedia().getRelationId());
            bannerEntity.setMultimedia(multimediaEntityOne);
        }
        return homeInfoEntity;
    }

}
