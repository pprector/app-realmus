package com.realmus.facade;

import com.alibaba.fastjson.JSON;
import com.realmus.common.enums.ExtendTypeEnum;
import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.enums.ModuleEnum;
import com.realmus.common.enums.MultimediaEnum;
import com.realmus.common.result.ResultModel;
import com.realmus.domain.entity.*;
import com.realmus.domain.repository.NavigationRepository;
import com.realmus.domain.service.NavigationService;
import com.realmus.facade.response.PageNavigationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hkpeng
 * @date 2021/12/21 - 14:53
 */
@SpringBootTest
class NavigationFacadeImplTest {
    private String str1 = "上海Realmus成立于2010年，是一家集研发、生产、批发为一体的专业公司。 瑞玛斯致力于世界各地的膳食补充剂基地。  \n" +
            "瑞勒姆斯凭借近20年的研发和生产经验，不断完善和完善研发和生产的高精度系统。 满足客户对高品质产品与服务的需求。  ";


    @Autowired
    private NavigationFacade navigationFacade;
    @Autowired
    private NavigationRepository navigationRepository;

    @Autowired
    private NavigationService navigationService;


    @Test
    void getNavigationInfo() {
        ResultModel<List<PageNavigationResponse>> navigationInfo = navigationFacade.getNavigationInfo(1);
        System.out.println(JSON.toJSONString(navigationInfo, true));
    }

    /**
     * 更新 Home 数据
     */
    @Test
    public void updateHomeInfoEntityInfo() {
        //1. 查询数据
        NavigationEntity<HomeInfoEntity> extendInfo = navigationRepository.findExtendInfo(LanguageEnum.CHINESE, ExtendTypeEnum.HOME_INFO.getId());
        System.out.println(JSON.toJSONString(extendInfo, true));

    }

    /**
     * 更新 关于我们 数据
     */
    @Test
    public void updateAboutUsEntityInfo() {
        //1. 查询数据
        NavigationEntity<AboutUsEntity> aboutUs = navigationRepository.findExtendInfo(LanguageEnum.CHINESE, ExtendTypeEnum.ABOUT_US.getId());
        System.out.println(JSON.toJSONString(aboutUs, true));
        //数据封装
        AboutUsEntity aboutUsEntity = new AboutUsEntity();
        // 模块 1 小banner
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/banner1.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("关于我们banner");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("url");
        bannerEntity.setInfoTitle("关于我们");
        bannerEntity.setInfoDescription("专业的健康食品化妆品供应商");
        bannerEntity.setInfoContent("");
        aboutUsEntity.setBanner(bannerEntity);
        //模块2 关于百合 视频
        CompanyEntity companyEntity = new CompanyEntity();

        MultimediaEntity videoBackgroundImg = new MultimediaEntity();
        videoBackgroundImg.setMultimediaType(MultimediaEnum.IMG);
        videoBackgroundImg.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/module2/videocover.jpg");
        videoBackgroundImg.setDescription("视频封面图");
        companyEntity.setVideoBackgroundImg(videoBackgroundImg);

        MultimediaEntity backgroundImg = new MultimediaEntity();
        backgroundImg.setMultimediaType(MultimediaEnum.IMG);
        backgroundImg.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/module2/background2.jpg");
        backgroundImg.setDescription("背景图片");
        companyEntity.setBackgroundImg(backgroundImg);

        MultimediaEntity promotionalMp4 = new MultimediaEntity();
        promotionalMp4.setMultimediaType(MultimediaEnum.VIDEO);
        promotionalMp4.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/module2/promotional.mp4");
        promotionalMp4.setDescription("关于我们视频");
        companyEntity.setPromotionalMp4(promotionalMp4);

        companyEntity.setInfoType(ModuleEnum.COMPANY);
        companyEntity.setH5Url("url");
        companyEntity.setInfoTitle("关于百合");
        companyEntity.setInfoDescription("专业的健康食品化妆品供应商");
        companyEntity.setInfoContent(str1);
        aboutUsEntity.setCompany(companyEntity);
        // 模块3 数据展示
        DataDisplayEntity displayEntity = new DataDisplayEntity();

        MultimediaEntity displayImgEntity = new MultimediaEntity();
        displayImgEntity.setMultimediaType(MultimediaEnum.IMG);
        displayImgEntity.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/module2/background2.jpg");
        displayImgEntity.setDescription("数据详情背景图");
        displayEntity.setBackground(displayImgEntity);

        List<DataDetailsEntity> dataDetailsEntityList = new ArrayList<>();
        dataDetailsEntityList.add(new DataDetailsEntity("30", "公顷", "区域范围"));
        dataDetailsEntityList.add(new DataDetailsEntity("79800", "平方米", "全世界客户覆盖"));
        dataDetailsEntityList.add(new DataDetailsEntity(">1600", "种类", "产品种类"));
        dataDetailsEntityList.add(new DataDetailsEntity("70", "百万瓶", "年生产"));

        displayEntity.setDataDetailsList(dataDetailsEntityList);
        aboutUsEntity.setDataDisplayEntity(displayEntity);

        // 模块4 资质信息
        List<MultimediaEntity> multimediaEntityList = new ArrayList<>();

        MultimediaEntity certification1 = new MultimediaEntity();
        certification1.setMultimediaType(MultimediaEnum.IMG);
        certification1.setDescription("证书信息");
        certification1.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/module2/zizhi1.png");

        MultimediaEntity certification2 = new MultimediaEntity();
        certification2.setMultimediaType(MultimediaEnum.IMG);
        certification2.setDescription("证书信息");
        certification2.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/module2/zizhi2.png");

        MultimediaEntity certification3 = new MultimediaEntity();
        certification3.setMultimediaType(MultimediaEnum.IMG);
        certification3.setDescription("证书信息");
        certification3.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/module2/zizhi3.png");


        MultimediaEntity certification4 = new MultimediaEntity();
        certification4.setMultimediaType(MultimediaEnum.IMG);
        certification4.setDescription("证书信息");
        certification4.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/module2/zizhi4.png");

        MultimediaEntity certification5 = new MultimediaEntity();
        certification5.setMultimediaType(MultimediaEnum.IMG);
        certification5.setDescription("证书信息");
        certification5.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/module2/zizhi5.png");

        multimediaEntityList.add(certification1);
        multimediaEntityList.add(certification2);
        multimediaEntityList.add(certification3);
        multimediaEntityList.add(certification4);
        multimediaEntityList.add(certification5);
        aboutUsEntity.setCertificationList(multimediaEntityList);

        //更新
        aboutUs.setExtension(aboutUsEntity);
        navigationService.updateNavigationInfo(LanguageEnum.CHINESE, aboutUs);
    }

    /**
     * 更新 新闻中心 数据
     */
    @Test
    public void updateNewsEntityInfo() {
        //1. 查询数据
        NavigationEntity<NewsEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.CHINESE, ExtendTypeEnum.NEWS.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        NewsEntity newsEntity = new NewsEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/banner3.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("新闻中心banner");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("url");
        bannerEntity.setInfoTitle("新闻中心");
        bannerEntity.setInfoDescription("为全民健康");
        bannerEntity.setInfoContent("");

        newsEntity.setBanner(bannerEntity);
        //更新
        navigationEntity.setExtension(newsEntity);
        navigationService.updateNavigationInfo(LanguageEnum.CHINESE, navigationEntity);
    }


    /**
     * 更新 智造中心 数据
     */
    @Test
    public void updateRDEntityInfo() {
        //1. 查询数据
        NavigationEntity<RDEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.CHINESE, ExtendTypeEnum.RD.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        RDEntity rdEntity = new RDEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/banner2.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("智造研发banner");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("url");
        bannerEntity.setInfoTitle("智造研发(R&D)");
        bannerEntity.setInfoDescription("致力打造全球领先的营养保健品智能工厂");
        bannerEntity.setInfoContent("");

        rdEntity.setBanner(bannerEntity);
        //更新
        navigationEntity.setExtension(rdEntity);
        navigationService.updateNavigationInfo(LanguageEnum.CHINESE, navigationEntity);
    }


    /**
     * 更新 产品中心 数据
     */
    @Test
    public void updatePRODUCTEntityInfo() {
        //1. 查询数据
        NavigationEntity<RDEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.CHINESE, ExtendTypeEnum.PRODUCT.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        RDEntity rdEntity = new RDEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/banner4.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("产品中心banner");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("url");
        bannerEntity.setInfoTitle("产品中心");
        bannerEntity.setInfoDescription("做一家受人尊重的企业,做一声良心质量的产品");
        bannerEntity.setInfoContent("");

        rdEntity.setBanner(bannerEntity);
        //更新
        navigationEntity.setExtension(rdEntity);
        navigationService.updateNavigationInfo(LanguageEnum.CHINESE, navigationEntity);
    }


    /**
     * 更新 产品中心 数据
     */
    @Test
    public void updateBrandEntityInfo() {
        //1. 查询数据
        NavigationEntity<BrandEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.CHINESE, ExtendTypeEnum.BRAND.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        BrandEntity brandEntity = new BrandEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/banner6.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("品牌中心banner");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("url");
        bannerEntity.setInfoTitle("品牌中心");
        bannerEntity.setInfoDescription("精准营养,健康赋能");
        bannerEntity.setInfoContent("");

        brandEntity.setBanner(bannerEntity);
        //更新
        navigationEntity.setExtension(brandEntity);
        navigationService.updateNavigationInfo(LanguageEnum.CHINESE, navigationEntity);
    }


    /**
     * 更新 外贸出口 数据
     */
    @Test
    public void updateForeignEntityInfo() {
        //1. 查询数据
        NavigationEntity<BrandEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.CHINESE, ExtendTypeEnum.FOREIGN.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        BrandEntity brandEntity = new BrandEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/banner5.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("外贸出口banner");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("url");
        bannerEntity.setInfoTitle("外贸出口");
        bannerEntity.setInfoDescription("来自中国, 面向全球");
        bannerEntity.setInfoContent("");

        brandEntity.setBanner(bannerEntity);
        //更新
        navigationEntity.setExtension(brandEntity);
        navigationService.updateNavigationInfo(LanguageEnum.CHINESE, navigationEntity);
    }


    /**
     * 更新 联系我们 数据
     */
    @Test
    public void updateContactUsEntityInfo() {
        //1. 查询数据
        NavigationEntity<BrandEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.CHINESE, ExtendTypeEnum.CONTACT_US.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        BrandEntity brandEntity = new BrandEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/banner7.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("联系我们banner");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("url");
        bannerEntity.setInfoTitle("联系我们");
        bannerEntity.setInfoDescription("一段佳话,从这里留言开始");
        bannerEntity.setInfoContent("");

        brandEntity.setBanner(bannerEntity);
        //更新
        navigationEntity.setExtension(brandEntity);
        navigationService.updateNavigationInfo(LanguageEnum.CHINESE, navigationEntity);
    }


}