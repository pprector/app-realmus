package com.realmus.domain.service;

import com.realmus.common.enums.ConstantEnum;
import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.enums.MultimediaEnum;
import com.realmus.domain.entity.BannerEntity;
import com.realmus.domain.entity.CompanyEntity;
import com.realmus.domain.entity.HomeInfoEntity;
import com.realmus.domain.entity.MultimediaEntity;
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
            if (bannerEntity.getBannerImg() == null) {
                continue;
            }
            MultimediaEntity multimediaEntityOne = multimediaRepository.getMultimediaEntityOne(bannerEntity.getBannerImg().getRelationId());
            bannerEntity.setBannerImg(multimediaEntityOne);
        }

        //2.填充模块2关于公司媒体信息
        CompanyEntity companyEntity = homeInfoEntity.getCompany();
        List<MultimediaEntity> companyMultimediaEntityList = multimediaRepository.getMultimediaEntityList(companyEntity.getRelationId());
        for (MultimediaEntity multimediaEntity : companyMultimediaEntityList) {
            if (multimediaEntity.getMultimediaType() == MultimediaEnum.IMG && ConstantEnum.CONSTANT_1.getDesc().equals(multimediaEntity.getDescription())) {
                companyEntity.setBackgroundImg(multimediaEntity);
                continue;
            }

            if (multimediaEntity.getMultimediaType() == MultimediaEnum.IMG && ConstantEnum.CONSTANT_3.getDesc().equals(multimediaEntity.getDescription())) {
                companyEntity.setVideoBackgroundImg(multimediaEntity);
                continue;
            }

            if (multimediaEntity.getMultimediaType() == MultimediaEnum.VIDEO && ConstantEnum.CONSTANT_2.getDesc().equals(multimediaEntity.getDescription())) {
                companyEntity.setPromotionalMp4(multimediaEntity);
                continue;
            }
        }
        return homeInfoEntity;
    }

}
