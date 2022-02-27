
package com.realmus.service.converter;

import com.realmus.common.enums.ExtendTypeEnum;
import com.realmus.domain.entity.*;
import com.realmus.facade.param.*;
import com.realmus.facade.response.NavAboutUsResponse;
import com.realmus.facade.response.NavBrandResponse;
import com.realmus.facade.response.NavContactUsResponse;
import com.realmus.facade.response.NavForeignResponse;
import com.realmus.facade.response.NavHomeResponse;
import com.realmus.facade.response.NavigationExtendResponse;
import com.realmus.facade.response.NewsResponse;
import com.realmus.facade.response.NavRDResponse;
import com.realmus.facade.response.NvaProductResponse;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hkpeng
 * @date 2021/12/22 - 14:29
 */

public class InfoConverter {

    public static NavHomeResponse toQueryHomeResponse(HomeInfoEntity homeInfoEntity) {
        if (homeInfoEntity == null) {
            return null;
        }
        NavHomeResponse homeResponse = new NavHomeResponse();

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
        //服务项目
        homeResponse.setServiceItem(toServiceItem(homeInfoEntity.getServiceItem()));

        return homeResponse;
    }

    private static ServiceItem toServiceItem(ServiceItemEntity entity) {
        if (entity == null) {
            return null;
        }
        ServiceItem serviceItem = new ServiceItem();
        serviceItem.setHeadLine(entity.getHeadLine());
        serviceItem.setDescription(entity.getDesc());
        serviceItem.setImg(toImg(entity.getMultimediaEntity()));

        List<PublicInfo> publicInfoList = entity.getItemInfoList().stream().map(InfoConverter::toPublicInfo).collect(Collectors.toList());
        serviceItem.setItemInfoList(publicInfoList);

        return serviceItem;

    }

    private static Img toImg(MultimediaEntity entity) {
        if (entity == null) {
            return null;
        }
        Img img = new Img();
        img.setUrl(entity.getMultimediaUrl());
        img.setDesc(entity.getDescription());

        return img;

    }

    private static PublicInfo toPublicInfo(PublicInfoEntity entity) {
        if (entity == null) {
            return null;
        }
        PublicInfo publicInfo = new PublicInfo();
        publicInfo.setH5Url(entity.getH5Url());
        publicInfo.setTitle(entity.getInfoTitle());
        publicInfo.setDesc(entity.getInfoDescription());
        publicInfo.setContent(entity.getInfoContent());

        return publicInfo;
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
            banner.setImg(new Img(entity.getBannerImg().getMultimediaUrl(), entity.getBannerImg().getDescription()));
        }
        return banner;
    }

    public static NavAboutUsResponse toAboutUsResponse(AboutUsEntity entity) {
        if (entity == null) {
            return null;
        }
        NavAboutUsResponse response = new NavAboutUsResponse();
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
            display.setBgImg(new Img(entity.getBackground().getMultimediaUrl(), entity.getBackground().getDescription()));
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

    public static NavRDResponse toRDResponse(RDEntity rdEntity) {
        if (rdEntity == null) {
            return null;
        }
        NavRDResponse rdResponse = new NavRDResponse();
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
        video.setVideoImg(new Img(entity.getCoverImgUrl(), "视频背景图"));
        video.setVideoUrl(entity.getMultimediaUrl());
        return video;
    }

    /**
     * 导航栏 扩展信息
     *
     * @param entity
     * @return
     */
    public static NavigationExtendResponse NavigationExtendResponse(NavigationEntity entity) {
        if (entity == null || StringUtils.isBlank(entity.getNavigationId())) {
            return null;
        }

        NavigationExtendResponse extendResponse = new NavigationExtendResponse();
        ExtendTypeEnum extendTypeEnum = ExtendTypeEnum.getLanguageEnum(entity.getNavigationId());
        switch (extendTypeEnum) {
            case HOME_INFO:
                HomeInfoEntity homeInfoEntity = (HomeInfoEntity) entity.getExtension();
                extendResponse.setHome(toQueryHomeResponse(homeInfoEntity));
                break;
            case ABOUT_US:
                AboutUsEntity aboutUsEntity = (AboutUsEntity) entity.getExtension();
                extendResponse.setAboutUs(toAboutUsResponse(aboutUsEntity));
                break;
            case NEWS:
                NewsEntity newsEntity = (NewsEntity) entity.getExtension();
                extendResponse.setNews(toNewsResponse(newsEntity));
                break;
            case RD:
                RDEntity rdEntity = (RDEntity) entity.getExtension();
                extendResponse.setRd(toRDResponse(rdEntity));
                break;
            case PRODUCT:
                ProductEntity productEntity = (ProductEntity) entity.getExtension();
                extendResponse.setProduct(toNavRDResponse(productEntity));
                break;
            case BRAND:
                BrandEntity brandEntity = (BrandEntity) entity.getExtension();
                extendResponse.setBrand(toNavBrandResponse(brandEntity));
                break;
            case FOREIGN:
                ForeignEntity foreignEntity = (ForeignEntity) entity.getExtension();
                extendResponse.setForeign(toNavForeignResponse(foreignEntity));
                break;
            case CONTACT_US:
                ContactUsEntity contactUsEntity = (ContactUsEntity) entity.getExtension();
                extendResponse.setContactUs(toNavContactUsResponse(contactUsEntity));
                break;
        }
        return extendResponse;
    }

    private static NavContactUsResponse toNavContactUsResponse(ContactUsEntity entity) {
        if (entity == null) {
            return null;
        }
        NavContactUsResponse response = new NavContactUsResponse();

        return null;
    }

    private static NavForeignResponse toNavForeignResponse(ForeignEntity foreignEntity) {
        NavForeignResponse response = new NavForeignResponse();

        return null;
    }

    private static NavBrandResponse toNavBrandResponse(BrandEntity brandEntity) {
        return null;
    }

    private static NvaProductResponse toNavRDResponse(ProductEntity productEntity) {
        return null;
    }

    private static NewsResponse toNewsResponse(NewsEntity newsEntity) {
        if (newsEntity == null) {
            return null;
        }
        return null;
    }
}

