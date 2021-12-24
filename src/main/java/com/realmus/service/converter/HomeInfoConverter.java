
package com.realmus.service.converter;

import com.realmus.domain.entity.BannerEntity;
import com.realmus.domain.entity.CompanyEntity;
import com.realmus.domain.entity.HomeInfoEntity;
import com.realmus.facade.param.Banner;
import com.realmus.facade.param.Company;
import com.realmus.facade.response.QueryHomeResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hkpeng
 * @date 2021/12/22 - 14:29
 */

public class HomeInfoConverter {

    public static QueryHomeResponse toQueryHomeResponse(HomeInfoEntity homeInfoEntity) {
        if (homeInfoEntity == null) {
            return null;
        }
        QueryHomeResponse homeResponse = new QueryHomeResponse();

        //轮播
        List<BannerEntity> bannerEntityList = homeInfoEntity.getBannerList();
        List<Banner> bannerList = bannerEntityList.stream().map(HomeInfoConverter::toBanner).collect(Collectors.toList());
        homeResponse.setBannerList(bannerList);
        //关于我们
        CompanyEntity companyEntity = homeInfoEntity.getCompany();
        homeResponse.setCompany(toCompany(companyEntity));
        //模块3 优势小 banner
        List<BannerEntity> advantageBannerEntityList = homeInfoEntity.getAdvantageBanner();
        List<Banner> advantageBannerList = advantageBannerEntityList.stream().map(HomeInfoConverter::toBanner).collect(Collectors.toList());
        homeResponse.setAdvantageBannerList(advantageBannerList);
        return homeResponse;
    }

    private static Company toCompany(CompanyEntity entity) {
        if (entity == null) {
            return null;
        }
        Company company = new Company();
        if (entity.getBackgroundImg() != null) {
            company.setBackgroundImg(entity.getBackgroundImg().getMultimediaUrl());
        }
        if (entity.getPromotionalMp4() != null) {
            company.setPromotionalMp4(entity.getPromotionalMp4().getMultimediaUrl());
        }
        if (entity.getVideoBackgroundImg() != null) {
            company.setVideoBackgroundImg(entity.getVideoBackgroundImg().getMultimediaUrl());
        }
        company.setInfoId(entity.getInfoId());
        company.setInfoType(entity.getInfoType().getCode());
        company.setH5Url(entity.getH5Url());
        company.setInfoTitle(entity.getInfoTitle());
        company.setInfoDescription(entity.getInfoDescription());
        company.setInfoContent(entity.getInfoContent());

        return company;
    }


    private static Banner toBanner(BannerEntity entity) {
        if (entity == null) {
            return null;
        }
        Banner banner = new Banner();
        banner.setInfoId(entity.getInfoId());
        banner.setInfoType(entity.getInfoType().getCode());
        banner.setH5Url(entity.getH5Url());
        banner.setInfoTitle(entity.getInfoTitle());
        banner.setInfoDescription(entity.getInfoDescription());
        banner.setInfoContent(entity.getInfoContent());
        if (entity.getBannerImg() != null) {
            banner.setImgUrl(entity.getBannerImg().getMultimediaUrl());
        }
        return banner;
    }
}
