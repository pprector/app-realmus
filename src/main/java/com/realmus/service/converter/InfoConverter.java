
package com.realmus.service.converter;

import com.realmus.domain.entity.*;
import com.realmus.facade.param.*;
import com.realmus.facade.response.AboutUsResponse;
import com.realmus.facade.response.HomeResponse;
import com.realmus.facade.response.RDResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hkpeng
 * @date 2021/12/22 - 14:29
 */

public class InfoConverter {

    public static HomeResponse toQueryHomeResponse(HomeInfoEntity homeInfoEntity) {
        if (homeInfoEntity == null) {
            return null;
        }
        HomeResponse homeResponse = new HomeResponse();

        //轮播
        List<BannerEntity> bannerEntityList = homeInfoEntity.getBannerList();
        List<Banner> bannerList = bannerEntityList.stream().map(InfoConverter::toBanner).collect(Collectors.toList());
        homeResponse.setBannerList(bannerList);
        //关于我们
        CompanyEntity companyEntity = homeInfoEntity.getCompany();
        homeResponse.setCompany(toCompany(companyEntity));
        //模块3 优势小 banner
        List<BannerEntity> advantageBannerEntityList = homeInfoEntity.getAdvantageBanner();
        List<Banner> advantageBannerList = advantageBannerEntityList.stream().map(InfoConverter::toBanner).collect(Collectors.toList());
        homeResponse.setAdvantageBannerList(advantageBannerList);
        return homeResponse;
    }

    private static Company toCompany(CompanyEntity entity) {
        if (entity == null) {
            return null;
        }
        Company company = new Company();
        if (entity.getBackgroundImg() != null) {
            company.setBgImg(entity.getBackgroundImg().getMultimediaUrl());
        }
        if (entity.getPromotionalMp4() != null) {
            company.setPromotionalMp4(entity.getPromotionalMp4().getMultimediaUrl());
        }
        if (entity.getVideoBackgroundImg() != null) {
            company.setVideoBgImg(entity.getVideoBackgroundImg().getMultimediaUrl());
        }
        company.setH5Url(entity.getH5Url());
        company.setTitle(entity.getInfoTitle());
        company.setDesc(entity.getInfoDescription());
        company.setContent(entity.getInfoContent());

        return company;
    }


    private static Banner toBanner(BannerEntity entity) {
        if (entity == null) {
            return null;
        }
        Banner banner = new Banner();

        banner.setH5Url(entity.getH5Url());
        banner.setTitle(entity.getInfoTitle());
        banner.setDesc(entity.getInfoDescription());
        banner.setContent(entity.getInfoContent());
        if (entity.getBannerImg() != null) {
            banner.setImgUrl(entity.getBannerImg().getMultimediaUrl());
        }
        return banner;
    }

    public static AboutUsResponse toAboutUsResponse(AboutUsEntity entity) {
        if (entity == null) {
            return null;
        }
        AboutUsResponse response = new AboutUsResponse();
        response.setBanner(toBanner(entity.getBanner()));
        response.setCompany(toCompany(entity.getCompany()));

        if (entity.getCourseBannerList() != null) {
            List<Banner> bannerList = entity.getCourseBannerList().stream().map(InfoConverter::toBanner).collect(Collectors.toList());
            response.setCourseBannerList(bannerList);
        }
        //数据展示模块
        DataDisplayEntity displayEntity = entity.getDataDisplayEntity();
        DataDisplay dataDisplay = toDataDisplay(displayEntity);
        response.setDataDisplay(dataDisplay);

        return response;
    }


    public static DataDisplay toDataDisplay(DataDisplayEntity entity) {
        if (entity == null) {
            return null;
        }
        DataDisplay display = new DataDisplay();
        if (entity.getBackground() != null) {
            display.setBgImg(entity.getBackground().getMultimediaUrl());
        }

        display.setDataDetailsList(entity.getDataDetailsList()
                .stream().map(InfoConverter::toDataDetails).collect(Collectors.toList()));

        return display;
    }

    public static DataDetails toDataDetails(DataDetailsEntity entity) {
        if (entity == null) {
            return null;
        }
        DataDetails details = new DataDetails();
        details.setNumber(entity.getNumber());
        details.setUnits(entity.getUnits());
        details.setDesc(entity.getDesc());
        return details;
    }

    public static RDResponse toRDResponse(RDEntity rdEntity) {
        if (rdEntity == null) {
            return null;
        }
        RDResponse rdResponse = new RDResponse();
        rdResponse.setBanner(toBanner(rdEntity.getBanner()));
        rdResponse.setIntelligentPlant(toIntelligentPlant(rdEntity.getIntelligentPlant()));
        rdResponse.setRdiInfo(toRdiInfo(rdEntity.getRdiInfo()));
        rdResponse.setRdLaboratory(toRdLaboratory(rdEntity.getRdLaboratory()));
        rdResponse.setRdQuality(toRdQuality(rdEntity.getRdQuality()));

        return rdResponse;
    }

    private static RDQuality toRdQuality(RDQualityEntity entity) {
        if (entity == null) {
            return null;
        }
        RDQuality quality = new RDQuality();
        quality.setMainBanner(toBanner(entity.getMainBanner()));
        quality.setQualityBanner(toBanner(entity.getQualityBanner()));
        quality.setPlatformBanner(toBanner(entity.getPlatformBanner()));
        quality.setLogisticsBanner(toBanner(entity.getLogisticsBanner()));

        return quality;
    }

    private static RDLaboratory toRdLaboratory(RDLaboratoryEntity entity) {
        if (entity == null) {
            return null;
        }
        RDLaboratory rdLaboratory = new RDLaboratory();
        rdLaboratory.setMainBanner(toBanner(entity.getMainBanner()));
        rdLaboratory.setTestingCenterBanner1(toBanner(entity.getTestingCenterBanner1()));
        rdLaboratory.setTestingCenterBanner2(toBanner(entity.getTestingCenterBanner2()));
        rdLaboratory.setTestItemBanner(toBanner(entity.getTestItemBanner()));
        rdLaboratory.setEquipmentBanner(toBanner(entity.getEquipmentBanner()));

        return rdLaboratory;

    }

    private static RDIInfo toRdiInfo(RDIInfoEntity entity) {
        if (entity == null) {
            return null;
        }
        RDIInfo info = new RDIInfo();
        info.setMainBanner(toBanner(entity.getMainBanner()));
        info.setHeadLine(entity.getHeadLine());
        info.setDesc(entity.getDescription());
        info.setDataBanner(toBanner(entity.getDatabaseBanner()));
        info.setTeamBanner(toBanner(entity.getTeamBanner()));
        info.setPatentBanner(toBanner(entity.getPatentBanner()));

        return info;
    }

    private static RDIntelligentPlant toIntelligentPlant(RDIntelligentPlantEntity entity) {
        if (entity == null) {
            return null;
        }
        RDIntelligentPlant plant = new RDIntelligentPlant();
        plant.setMainBanner(toBanner(entity.getMainBanner()));
        plant.setFactoryBanner(toBanner(entity.getFactoryBanner()));

        plant.setVideoList(entity.getVideoList().stream().map(InfoConverter::toVideo).collect(Collectors.toList()));

        return plant;
    }

    public static Video toVideo(VideoEntity entity) {
        if (entity == null) {
            return null;
        }
        Video video = new Video();
        video.setVideoImgUrl(entity.getCoverImgUrl());
        video.setVideoUrl(entity.getMultimediaUrl());
        return video;
    }
}

