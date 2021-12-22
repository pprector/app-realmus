
package com.realmus.service.converter;

import com.realmus.domain.entity.BannerEntity;
import com.realmus.domain.entity.HomeInfoEntity;
import com.realmus.facade.param.Banner;
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

        List<BannerEntity> bannerEntityList = homeInfoEntity.getBannerList();
        //轮播
        List<Banner> bannerList = bannerEntityList.stream().map(HomeInfoConverter::toBanner).collect(Collectors.toList());
        homeResponse.setBannerList(bannerList);
        return homeResponse;
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
        if (entity.getMultimedia() != null){
            banner.setImgUrl(entity.getMultimedia().getMultimediaUrl());
        }

        return banner;
    }
}
