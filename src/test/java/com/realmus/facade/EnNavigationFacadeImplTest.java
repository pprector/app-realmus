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
import com.realmus.facade.response.NavigationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/21 - 14:53
 */
@SpringBootTest
class EnNavigationFacadeImplTest {
    private String str1 = "Shanghai realmus was founded in 2010, which is a specialized company focused on the research and development , manufacturing and wholesale. Realmus devotes herself to dietary supplements base all orver the world." +
            "Realmus with near 20 years experience on the R & D and production is improved and comsummated the hight precision of the research and production system. To meet customers demand for hight quality life style .  ";


    @Autowired
    private NavigationFacade navigationFacade;
    @Autowired
    private NavigationRepository navigationRepository;

    @Autowired
    private NavigationService navigationService;


    @Test
    void getNavigationInfo() {
        ResultModel<List<NavigationResponse>> navigationInfo = navigationFacade.getNavigationInfo(null);
        System.out.println(JSON.toJSONString(navigationInfo, true));
    }

    /**
     * 更新 Home 数据
     */
    @Test
    public void updateHomeInfoEntityInfo() {
        //1. 查询数据
        NavigationEntity<HomeInfoEntity> homeInfo = navigationRepository.findExtendInfo(LanguageEnum.ENGLISH, ExtendTypeEnum.HOME_INFO.getId());
        HomeInfoEntity homeInfoEntity = new HomeInfoEntity();

        List<BannerEntity> bannerEntityList = new ArrayList<>();
        BannerEntity bannerEntity1 = new BannerEntity();
        MultimediaEntity multimediaEntity1 = new MultimediaEntity();
        multimediaEntity1.setMultimediaUrl("/home/banner/banner1.jpg");
        multimediaEntity1.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity1.setDescription("OEM");
        bannerEntity1.setBannerImg(multimediaEntity1);

        bannerEntity1.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity1.setH5Url("url");
        bannerEntity1.setInfoTitle("Innovation can assign");
        bannerEntity1.setInfoDescription("Supplier of healthcare video OEM/ODM solutions for decades");
        bannerEntity1.setInfoContent("Realmus provides you with a one-stop service without any worries");

        bannerEntityList.add(bannerEntity1);

        BannerEntity bannerEntity2 = new BannerEntity();
        MultimediaEntity multimediaEntity2 = new MultimediaEntity();
        multimediaEntity2.setMultimediaUrl("/home/banner/banner2.jpg");
        multimediaEntity2.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity2.setDescription("OEM");
        bannerEntity2.setBannerImg(multimediaEntity2);

        bannerEntity2.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity2.setH5Url("url");
        bannerEntity2.setInfoTitle("global-oriented");
        bannerEntity2.setInfoDescription("Committed to become the global health food industry leader");
        bannerEntity2.setInfoContent("");

        bannerEntityList.add(bannerEntity2);

        BannerEntity bannerEntity3 = new BannerEntity();
        MultimediaEntity multimediaEntity3 = new MultimediaEntity();
        multimediaEntity3.setMultimediaUrl("/home/banner/banner3.jpg");
        multimediaEntity3.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity3.setDescription("OEM");
        bannerEntity3.setBannerImg(multimediaEntity3);

        bannerEntity3.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity3.setH5Url("url");
        bannerEntity3.setInfoTitle("Focus on health");
        bannerEntity3.setInfoDescription("Has the world's leading nutrition and health products manufacturing plant");
        bannerEntity3.setInfoContent("");

        bannerEntityList.add(bannerEntity3);

        //模块2
        CompanyEntity companyEntity = new CompanyEntity();

        MultimediaEntity videoBackgroundImg = new MultimediaEntity();
        videoBackgroundImg.setMultimediaType(MultimediaEnum.IMG);
        videoBackgroundImg.setMultimediaUrl("/home/module2/videocover.jpg");
        videoBackgroundImg.setDescription("OEM Video");
        companyEntity.setVideoBackgroundImg(videoBackgroundImg);
        //1
        MultimediaEntity backgroundImg = new MultimediaEntity();
        backgroundImg.setMultimediaType(MultimediaEnum.IMG);
        backgroundImg.setMultimediaUrl("/home/module2/background%20.jpg");
        backgroundImg.setDescription("OEM Video");
        companyEntity.setBackgroundImg(backgroundImg);

        MultimediaEntity promotionalMp4 = new MultimediaEntity();
        promotionalMp4.setMultimediaType(MultimediaEnum.VIDEO);
        promotionalMp4.setMultimediaUrl("/home/video/realmus202204.mp4");
        promotionalMp4.setDescription("OEM Video");
        companyEntity.setPromotionalMp4(promotionalMp4);

        companyEntity.setInfoType(ModuleEnum.COMPANY);
        companyEntity.setH5Url("url");
        companyEntity.setInfoTitle("About Us");
        companyEntity.setInfoDescription("We are professional  healthy supplement supplier , service ODM/OEM more than 10years!\n" +
                "Health food, nutritional supplements professional supplier");
        companyEntity.setInfoContent("Shanghai realmus Industrial Co., Ltd. was established in 2010, specializing in nutritional supplementsand other service.  For decades, with the high recognition of product quality from domestic and foreign customers, we have created a good brand reputation in the industry.  With professional research and development ability, perfect manufacturing technology, strict quality control system, and constantly strengthen the competitiveness and influence in the field of nutrition and health food.  \n" +
                "The products mainly cover soft capsule, hard capsule, tablet, soft candy, powder (solid drink), oral liquid, cosmetics, granules, drops, bottle drink, soft drink and other dosage forms;  shanghai realmus industrial Co.,Ltd. has developed more than 5000 dietary supplement formulations, products  have been exported to the United States, Canada, Mexico, Chile, Brazil, Argentina, Colombia, The United Kingdom, Germany, Russia and other more than 40 Countries ,we also develop a wide range of markets in the Southeast Asian.\n" +
                "At present, passed ISO9001, ISO14001, HACCP, KOSHER certification and FDA registration. ");
        //小  banner
        List<BannerEntity> bannerEntityList2 = new ArrayList<>();
        BannerEntity bannerEntity4 = new BannerEntity();
        MultimediaEntity multimediaEntity4 = new MultimediaEntity();
        multimediaEntity4.setMultimediaUrl("/home/module3/1module3.jpg");
        multimediaEntity4.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity4.setDescription("OEM");
        bannerEntity4.setBannerImg(multimediaEntity4);

        bannerEntity4.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity4.setH5Url("url");
        bannerEntity4.setInfoTitle("research and development");
        bannerEntity4.setInfoDescription("");
        bannerEntity4.setInfoContent("CNAS laboratory accreditation standards testing center, with more than 100 professional R & D team, equipped with from the United States, Japan, gas, liquid chromatograph, photometer, gas, liquid mass spectrometry and other imported testing equipment, and the ENGLISH Academy of Sciences, Ocean University of China and other well-known universities, increasing investment in RESEARCH and development,  Up to now, there are 213 health food formulations which have obtained approval certificate and record certificate, ranking in the forefront of industry development.  ");

        bannerEntityList2.add(bannerEntity4);

        BannerEntity bannerEntity5 = new BannerEntity();
        MultimediaEntity multimediaEntity5 = new MultimediaEntity();
        multimediaEntity5.setMultimediaUrl("/home/module3/2model3.jpg");
        multimediaEntity5.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity5.setDescription("OEM");
        bannerEntity5.setBannerImg(multimediaEntity5);

        bannerEntity5.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity5.setH5Url("url");
        bannerEntity5.setInfoTitle("export country");
        bannerEntity5.setInfoDescription("");
        bannerEntity5.setInfoContent("Realmus cooperates with 65 countries in the world and now has two factories of more than 150 mu, more than 20,000 flat rice purification workshops, dozens of soft capsule, hard capsule, tablet, powder, granule, oral liquid and other modern production lines, can develop more than 2000 kinds of health food, SC nutrition food, pregnant, infant and children supplementary food  ");

        bannerEntityList2.add(bannerEntity5);


        BannerEntity bannerEntity6 = new BannerEntity();
        MultimediaEntity multimediaEntity6 = new MultimediaEntity();
        multimediaEntity6.setMultimediaUrl("/home/module3/3model3.jpg");
        multimediaEntity6.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity6.setDescription("模块3图3");
        bannerEntity6.setBannerImg(multimediaEntity6);

        bannerEntity6.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity6.setH5Url("url");
        bannerEntity6.setInfoTitle("development history ");
        bannerEntity6.setInfoDescription("");
        bannerEntity6.setInfoContent("In 2005, health food production enterprises should have good production equipment, reasonable production process, perfect quality management and strict testing system to ensure that the final product quality meets the requirements of laws and regulations  ");

        bannerEntityList2.add(bannerEntity6);

        BannerEntity bannerEntity7 = new BannerEntity();
        MultimediaEntity multimediaEntity7 = new MultimediaEntity();
        multimediaEntity7.setMultimediaUrl("/home/module3/4model3.jpg");
        multimediaEntity7.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity7.setDescription("模块3图4");
        bannerEntity7.setBannerImg(multimediaEntity7);

        bannerEntity7.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity7.setH5Url("url");
        bannerEntity7.setInfoTitle("cooperative partner");
        bannerEntity7.setInfoDescription("");
        bannerEntity7.setInfoContent("Has more than 100 professional r&d team, equipped with gas from the United States, Japan, liquid chromatograph, spectrophotometer, such as gas, liquid mass combination instrument imported testing equipment, with the ENGLISH Academy of Sciences, China ocean university, and many other well-known colleges and universities cooperation, continuously increased investment in research and development, has obtained the approval certificate and registration certificate of health food formula 213, ranked among the top industry development.  ");

        bannerEntityList2.add(bannerEntity7);
        //服务项目
        ServiceItemEntity serviceItemEntity = new ServiceItemEntity();
        serviceItemEntity.setHeadLine("Service project");
        serviceItemEntity.setDesc("Realmus provides you with wordless service from conception to product.。");
        MultimediaEntity multimediaEntityItem = new MultimediaEntity();
        multimediaEntityItem.setMultimediaUrl("/home/serviceItem/page2bg.jpg");
        multimediaEntityItem.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntityItem.setDescription("服务项目背景图");
        serviceItemEntity.setMultimediaEntity(multimediaEntityItem);

        homeInfoEntity.setAdvantageBanner(bannerEntityList2);
        homeInfoEntity.setCompany(companyEntity);


        //信息列表
        ArrayList<PublicInfoEntity> publicInfoEntityList = new ArrayList<>();
        PublicInfoEntity infoEntity1 = new PublicInfoEntity();
        infoEntity1.setInfoTitle("market analysis ");
        infoEntity1.setInfoDescription("Share cutting edge information to help you develop valuable growth strategies");
        infoEntity1.setInfoContent("Kosher Gummy is the first kosher Gummy supplier in China and the only one approved by the National Jewish Certification Authority  ");
        publicInfoEntityList.add(infoEntity1);

        PublicInfoEntity infoEntity2 = new PublicInfoEntity();
        infoEntity2.setInfoTitle("Research and Development");
        infoEntity2.setInfoDescription("Professional R & D team, to provide you with leading product solutions.");
        infoEntity2.setInfoContent("2000+ formula products, 10+ dosage forms,50+ QAQC,50+ imported testing equipment, 300+ test indicators, product development in all dimensions: dosage form, function, population, gender, age, regional population characteristics, taste, shape, new trends, usage, packaging specifications, regional preferences, color, temperature, human absorbance cost, ingredients.  ");
        publicInfoEntityList.add(infoEntity2);

        PublicInfoEntity infoEntity3 = new PublicInfoEntity();
        infoEntity3.setInfoTitle("Production and packaging");
        infoEntity3.setInfoDescription("In accordance with GMP standards, we provide multi-dosage products, supplemented by a variety of innovative packaging for your choice.  ");
        infoEntity3.setInfoContent("From raw materials to finished products, the whole process of quality control can be traced back to the production workshop of 100,000 clean grades, 24-hour constant temperature and humidity.  More than 30 automatic packaging production lines, to provide customers with a variety of packaging solutions, equipped with automatic bottles, boxes, aluminum foil board, barrels, bags, single packaging and other packaging equipment.  ");
        publicInfoEntityList.add(infoEntity3);

        PublicInfoEntity infoEntity4 = new PublicInfoEntity();
        infoEntity4.setInfoTitle("supply chain management");
        infoEntity4.setInfoDescription("Strict supply chain access matrix, from the source to control product quality, optimize costs, improve efficiency.  ");
        infoEntity4.setInfoContent("With the world famous food, health food raw material suppliers to maintain cooperation, all selected supply chain through the relevant national industry requirements.  DSM, BASF, Bayer, Danisco...   ");
        publicInfoEntityList.add(infoEntity4);

        PublicInfoEntity infoEntity5 = new PublicInfoEntity();
        infoEntity5.setInfoTitle("service and support");
        infoEntity5.setInfoDescription("In the whole link to provide you with professional services and support, become your effective partner.  ");
        infoEntity5.setInfoContent("Provide embassy certification, customer local registration required certificate certification.  Product follow-up upgrade service, door to door transportation service  ");
        publicInfoEntityList.add(infoEntity5);
        homeInfoEntity.setBannerList(bannerEntityList);

        serviceItemEntity.setItemInfoList(publicInfoEntityList);
        homeInfoEntity.setServiceItem(serviceItemEntity);
        System.out.println(JSON.toJSONString(homeInfo, true));


        homeInfo.setExtension(homeInfoEntity);
        navigationService.updateNavigationInfo(LanguageEnum.ENGLISH, homeInfo);

    }

    /**
     * 更新 关于我们 数据
     */
    @Test
    public void updateAboutUsEntityInfo() {
        //1. 查询数据
        NavigationEntity<AboutUsEntity> aboutUs = navigationRepository.findExtendInfo(LanguageEnum.ENGLISH, ExtendTypeEnum.ABOUT_US.getId());
        System.out.println(JSON.toJSONString(aboutUs, true));
        //数据封装
        AboutUsEntity aboutUsEntity = new AboutUsEntity();
        // 模块 1 小banner
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("/home/dataImg/banner1.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("Realmus banner");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("/about");
        bannerEntity.setInfoTitle("About us  ");
        bannerEntity.setInfoDescription("We are professional  healthy supplement supplier , service ODM/OEM more than 10years!\\n\" +\n" +
                "                \"Health food, nutritional supplements professional supplier");
        bannerEntity.setInfoContent("");
        aboutUsEntity.setBanner(bannerEntity);
        //模块2 关于Realmus 视频
        CompanyEntity companyEntity = new CompanyEntity();

        MultimediaEntity videoBackgroundImg = new MultimediaEntity();
        videoBackgroundImg.setMultimediaType(MultimediaEnum.IMG);
        videoBackgroundImg.setMultimediaUrl("/home/module2/videocover.jpg");
        videoBackgroundImg.setDescription("Realmus Video BG");
        companyEntity.setVideoBackgroundImg(videoBackgroundImg);

        MultimediaEntity backgroundImg = new MultimediaEntity();
        backgroundImg.setMultimediaType(MultimediaEnum.IMG);
        backgroundImg.setMultimediaUrl("/home/module2/background2.jpg");
        backgroundImg.setDescription("Realmus Bg");
        companyEntity.setBackgroundImg(backgroundImg);

        MultimediaEntity promotionalMp4 = new MultimediaEntity();
        promotionalMp4.setMultimediaType(MultimediaEnum.VIDEO);
        promotionalMp4.setMultimediaUrl("/home/video/realmus202204.mp4");
        promotionalMp4.setDescription("Realmus Video");
        companyEntity.setPromotionalMp4(promotionalMp4);

        companyEntity.setInfoType(ModuleEnum.COMPANY);
        companyEntity.setH5Url("url");
        companyEntity.setInfoTitle("About Us");
        companyEntity.setInfoDescription("Professional supplier of health food and cosmetics");
        companyEntity.setInfoContent(str1);
        aboutUsEntity.setCompany(companyEntity);
        // 模块3 数据展示
        DataDisplayEntity displayEntity = new DataDisplayEntity();

        MultimediaEntity displayImgEntity = new MultimediaEntity();
        displayImgEntity.setMultimediaType(MultimediaEnum.IMG);
        displayImgEntity.setMultimediaUrl("/home/module2/background2.jpg");
        displayImgEntity.setDescription("data img Bg");
        displayEntity.setBackground(displayImgEntity);

        List<DataDetailsEntity> dataDetailsEntityList = new ArrayList<>();
        dataDetailsEntityList.add(new DataDetailsEntity("30", "hectare", "area coverage"));
        dataDetailsEntityList.add(new DataDetailsEntity("79800", "square meter", "Worldwide customer coverage"));
        dataDetailsEntityList.add(new DataDetailsEntity(">2000", "kind", "type of production"));
        dataDetailsEntityList.add(new DataDetailsEntity("70", "Millions of bottles", "Annual production"));

        displayEntity.setDataDetailsList(dataDetailsEntityList);
        aboutUsEntity.setDataDisplayEntity(displayEntity);

        // 模块4 资质信息
        List<MultimediaEntity> multimediaEntityList = new ArrayList<>();

        MultimediaEntity certification1 = new MultimediaEntity();
        certification1.setMultimediaType(MultimediaEnum.IMG);
        certification1.setDescription("Realmus Certificate");
        certification1.setMultimediaUrl("/home/module2/zizhi1.png");

        MultimediaEntity certification2 = new MultimediaEntity();
        certification2.setMultimediaType(MultimediaEnum.IMG);
        certification2.setDescription("Realmus Certificate");
        certification2.setMultimediaUrl("/home/module2/zizhi2.png");

        MultimediaEntity certification3 = new MultimediaEntity();
        certification3.setMultimediaType(MultimediaEnum.IMG);
        certification3.setDescription("Realmus Certificate");
        certification3.setMultimediaUrl("/home/module2/zizhi3.png");


        MultimediaEntity certification4 = new MultimediaEntity();
        certification4.setMultimediaType(MultimediaEnum.IMG);
        certification4.setDescription("Realmus Certificate");
        certification4.setMultimediaUrl("/home/module2/zizhi4.png");

        MultimediaEntity certification5 = new MultimediaEntity();
        certification5.setMultimediaType(MultimediaEnum.IMG);
        certification5.setDescription("Realmus Certificate");
        certification5.setMultimediaUrl("/home/module2/zizhi5.png");

        multimediaEntityList.add(certification1);
        multimediaEntityList.add(certification2);
        multimediaEntityList.add(certification3);
        multimediaEntityList.add(certification4);
        multimediaEntityList.add(certification5);
        aboutUsEntity.setCertificationList(multimediaEntityList);
        //发展历程


        List<BannerEntity> bannerEntities = new ArrayList<>();

        BannerEntity Lcentity1 = new BannerEntity();
        MultimediaEntity multimedialc1 = new MultimediaEntity();
        multimedialc1.setMultimediaUrl("/home/banner/banner3.jpg");
        multimedialc1.setMultimediaType(MultimediaEnum.IMG);
        multimedialc1.setDescription("发展历程");
        Lcentity1.setBannerImg(multimedialc1);

        Lcentity1.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        Lcentity1.setInfoTitle("2010");
        Lcentity1.setInfoDescription("It was established in 2010");
        Lcentity1.setInfoContent("");

        bannerEntities.add(Lcentity1);


        BannerEntity Lcentity2 = new BannerEntity();
        MultimediaEntity multimedialc2 = new MultimediaEntity();
        multimedialc2.setMultimediaUrl("/home/banner/banner3.jpg");
        multimedialc2.setMultimediaType(MultimediaEnum.IMG);
        multimedialc2.setDescription("发展历程");
        Lcentity2.setBannerImg(multimedialc1);

        Lcentity2.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        Lcentity2.setInfoTitle("2011");
        Lcentity2.setInfoDescription("In 2011, our products were exported to Thailand, the United States and Brazil. Brazil and the United States visited our company and highly recognized our products  ");
        Lcentity2.setInfoContent("");

        bannerEntities.add(Lcentity2);


        BannerEntity Lcentity3 = new BannerEntity();
        MultimediaEntity multimedialc3 = new MultimediaEntity();
        multimedialc3.setMultimediaUrl("/home/banner/banner3.jpg");
        multimedialc3.setMultimediaType(MultimediaEnum.IMG);
        multimedialc3.setDescription("发展历程");
        Lcentity3.setBannerImg(multimedialc2);

        Lcentity3.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        Lcentity3.setInfoTitle("2013");
        Lcentity3.setInfoDescription("2013 To become a quality supplier of Singapore pharmaceutical factories");
        Lcentity3.setInfoContent("");

        bannerEntities.add(Lcentity3);


        BannerEntity Lcentity4 = new BannerEntity();
        MultimediaEntity multimedialc4 = new MultimediaEntity();
        multimedialc4.setMultimediaUrl("/home/banner/banner3.jpg");
        multimedialc4.setMultimediaType(MultimediaEnum.IMG);
        multimedialc4.setDescription("发展历程");
        Lcentity4.setBannerImg(multimedialc4);

        Lcentity4.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        Lcentity4.setInfoTitle("2014");
        Lcentity4.setInfoDescription("The UK company was established in 2014");
        Lcentity4.setInfoContent("");

        bannerEntities.add(Lcentity4);

        BannerEntity Lcentity5 = new BannerEntity();
        MultimediaEntity multimedialc5 = new MultimediaEntity();
        multimedialc5.setMultimediaUrl("/home/banner/banner3.jpg");
        multimedialc5.setMultimediaType(MultimediaEnum.IMG);
        multimedialc5.setDescription("发展历程");
        Lcentity5.setBannerImg(multimedialc5);

        Lcentity5.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        Lcentity5.setInfoTitle("2015");
        Lcentity5.setInfoDescription("Develop fudge products and certified Kosher to develop the domestic market realmus brand  ");
        Lcentity5.setInfoContent("");

        bannerEntities.add(Lcentity5);

        BannerEntity Lcentity6 = new BannerEntity();
        MultimediaEntity multimedialc6 = new MultimediaEntity();
        multimedialc6.setMultimediaUrl("/home/banner/banner3.jpg");
        multimedialc6.setMultimediaType(MultimediaEnum.IMG);
        multimedialc6.setDescription("发展历程");
        Lcentity6.setBannerImg(multimedialc6);

        Lcentity6.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        Lcentity6.setInfoTitle("2017 ");
        Lcentity6.setInfoDescription("2017 Henan Office was established");
        Lcentity6.setInfoContent("");

        bannerEntities.add(Lcentity6);

        BannerEntity Lcentity7 = new BannerEntity();
        MultimediaEntity multimedialc7= new MultimediaEntity();
        multimedialc7.setMultimediaUrl("/home/banner/banner3.jpg");
        multimedialc7.setMultimediaType(MultimediaEnum.IMG);
        multimedialc7.setDescription("发展历程");
        Lcentity7.setBannerImg(multimedialc7);

        Lcentity7.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        Lcentity7.setInfoTitle("2019 ");
        Lcentity7.setInfoDescription("2019 exports more than 40 countries");
        Lcentity7.setInfoContent("");

        bannerEntities.add(Lcentity7);


        BannerEntity Lcentity8 = new BannerEntity();
        MultimediaEntity multimedialc8= new MultimediaEntity();

        multimedialc8.setMultimediaUrl("/home/banner/banner3.jpg");
        multimedialc8.setMultimediaType(MultimediaEnum.IMG);
        multimedialc8.setDescription("发展历程");
        Lcentity8.setBannerImg(multimedialc8);

        Lcentity8.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        Lcentity8.setInfoTitle("2021");
        Lcentity8.setInfoDescription("In 2021, a Kosher certified fudge factory will be established - kouxi brand will be established");
        Lcentity8.setInfoContent("");

        bannerEntities.add(Lcentity8);

        aboutUsEntity.setCourseBannerList(bannerEntities);
        //更新
        aboutUs.setExtension(aboutUsEntity);
        navigationService.updateNavigationInfo(LanguageEnum.ENGLISH, aboutUs);
    }

    /**
     * 更新 新闻中心 数据
     */
    @Test
    public void updateNewsEntityInfo() {
        //1. 查询数据
        NavigationEntity<NewsEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.ENGLISH, ExtendTypeEnum.NEWS.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        NewsEntity newsEntity = new NewsEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("/home/dataImg/banner3.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("News banner");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("url");
        bannerEntity.setInfoTitle("News ");
        bannerEntity.setInfoDescription("For the health of all");
        bannerEntity.setInfoContent("");

        newsEntity.setBanner(bannerEntity);
        //更新
        navigationEntity.setExtension(newsEntity);
        navigationService.updateNavigationInfo(LanguageEnum.ENGLISH, navigationEntity);
    }


    /**
     * 更新 智造研发 数据
     */
    @Test
    public void updateRDEntityInfo() {
        // 查询数据
        NavigationEntity<RDEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.ENGLISH, ExtendTypeEnum.RD.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        //1.通用banner
        RDEntity rdEntity = new RDEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("/home/dataImg/banner2.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("Research and development banner");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("/research");
        bannerEntity.setInfoTitle("Research and Development(R&D)");
        bannerEntity.setInfoDescription("It is committed to building the world's leading intelligent factory of nutrition and health products");
        bannerEntity.setInfoContent("");


        //2.智能工厂数据
        RDIntelligentPlantEntity intelligentPlant = new RDIntelligentPlantEntity();
        //2.1 主banner
        BannerEntity mainBanner = new BannerEntity();
        MultimediaEntity bannerImg1 = new MultimediaEntity();
        bannerImg1.setMultimediaType(MultimediaEnum.IMG);
        bannerImg1.setMultimediaUrl("/home/dataImg/banner10.jpg");
        bannerImg1.setDescription("Research and development of the factory");

        mainBanner.setBannerImg(bannerImg1);
        mainBanner.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner.setH5Url("url");
        mainBanner.setInfoTitle("Intelligent Plant");
        mainBanner.setInfoDescription("Intelligent - Intelligent manufacturing new technology to boost industry 4.0 lean production");
        mainBanner.setInfoContent("Intelligent equipment, intelligent production, intelligent creation from the traditional factory to the direction of intelligent factory development, the use of product digitalization, production digitalization, equipment digitalization, management data, in order to achieve the \"6 1\" digital management goals:  That is to manage every employee, manage every order, manage every material, manage every process, manage every equipment, manage every fund, production management is more precise, more transparent, more flexible!  ");

        BannerEntity factoryBanner = new BannerEntity();
        MultimediaEntity bannerImg2 = new MultimediaEntity();
        bannerImg2.setMultimediaType(MultimediaEnum.IMG);
        bannerImg2.setMultimediaUrl("/home/dataImg/banner11.jpg");
        bannerImg2.setDescription("Research and development of the factory");
        //详情
        factoryBanner.setBannerImg(bannerImg2);
        factoryBanner.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        factoryBanner.setH5Url("url");
        factoryBanner.setInfoTitle("Smart equipment, smart production, smart creation");
        factoryBanner.setInfoDescription("");
        factoryBanner.setInfoContent("Intelligent equipment, intelligent production, intelligent creation from the traditional factory to the direction of intelligent factory development, the use of product digitalization, production digitalization, equipment digitalization, management data, in order to achieve the \"6 1\" digital management goals:  That is to manage every employee, manage every order, manage every material, manage every process, manage every equipment, manage every fund, production management is more precise, more transparent, more flexible!  ");
        //3 工厂视频集合
        List<VideoEntity> videoList = new ArrayList<>();

        VideoEntity videoEntity1 = new VideoEntity();
        videoEntity1.setCoverImgUrl("/home/video/vimg1.jpg");
        videoEntity1.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity1.setMultimediaUrl("/home/video/vimg1.mp4");
        videoEntity1.setDescription("Trend good nutrition beverage production factory");

        VideoEntity videoEntity2 = new VideoEntity();
        videoEntity2.setCoverImgUrl("/home/video/vimg2.jpg");
        videoEntity2.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity2.setMultimediaUrl("/home/video/vimg2.mp4");
        videoEntity2.setDescription("Innovative functional soft and hard capsule production factory");

        VideoEntity videoEntity3 = new VideoEntity();
        videoEntity3.setCoverImgUrl("/home/video/vimg3.jpg");
        videoEntity3.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity3.setMultimediaUrl("/home/video/vimg3.mp4");
        videoEntity3.setDescription("Functional sense of science and technology to operate nutrition production plants");

        VideoEntity videoEntity4 = new VideoEntity();
        videoEntity4.setCoverImgUrl("/home/video/vimg4.jpg");
        videoEntity4.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity4.setMultimediaUrl("/home/video/vimg4.mp4");
        videoEntity4.setDescription("Delicious snacks of the tablet factory");

        VideoEntity videoEntity5 = new VideoEntity();
        videoEntity5.setCoverImgUrl("/home/video/vimg5.jpg");
        videoEntity5.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity5.setMultimediaUrl("/home/video/vimg5.mp4");
        videoEntity5.setDescription("Simple not simple powder factory");

        VideoEntity videoEntity6 = new VideoEntity();
        videoEntity6.setCoverImgUrl("/home/video/vimg6.jpg");
        videoEntity6.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity6.setMultimediaUrl("/home/video/vimg6.mp4");
        videoEntity6.setDescription("Scientific nutrition of the special diet food production factory");

        VideoEntity videoEntity7 = new VideoEntity();
        videoEntity7.setCoverImgUrl("/home/video/vimg7.jpg");
        videoEntity7.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity7.setMultimediaUrl("/home/video/vimg7.mp4");
        videoEntity7.setDescription("Rigorous and intelligent probiotic production plant");

        videoList.add(videoEntity7);
        videoList.add(videoEntity6);
        videoList.add(videoEntity5);
        videoList.add(videoEntity4);
        videoList.add(videoEntity3);
        videoList.add(videoEntity2);
        videoList.add(videoEntity1);

        VideoModelEntity videoModelEntity = new VideoModelEntity();
        videoModelEntity.setVideoList(videoList);
        videoModelEntity.setTitle("Large and wide innovation and intelligent manufacturing capacity");


        intelligentPlant.setVideoModel(videoModelEntity);
        intelligentPlant.setFactoryBanner(factoryBanner);
        intelligentPlant.setMainBanner(mainBanner);

        //3. 研发创新模块
        RDIInfoEntity rdiInfoEntity = new RDIInfoEntity();


        BannerEntity mainBanner3 = new BannerEntity();
        MultimediaEntity bannerImg3 = new MultimediaEntity();
        bannerImg3.setMultimediaType(MultimediaEnum.IMG);
        bannerImg3.setMultimediaUrl("/home/dataImg/yanfa1.jpg");
        bannerImg3.setDescription("research and development");

        mainBanner3.setBannerImg(bannerImg3);
        mainBanner3.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner3.setH5Url("url");
        mainBanner3.setInfoTitle("research and development");
        mainBanner3.setInfoDescription("Focus on refreshing the new standards of nutrition and health food");
        mainBanner3.setInfoContent("Long-term cooperation with many domestic and foreign universities, the annual scientific research investment of more than 20 million yuan;  More than 300 kinds of products have been developed and nearly 100 patents have been authorized.");

        rdiInfoEntity.setMainBanner(mainBanner3);
        //3.2 头
        rdiInfoEntity.setHeadLine("Continuous breakthroughs were made in R&D and innovation");
        rdiInfoEntity.setDescription(" It pays attention to the coordinated development of industry, education and research, and has long-term cooperation with many domestic and foreign colleges and universities. It has a well-known professional think tank team integrating consulting, RESEARCH and development, and sales, with an annual scientific research investment of 20 million yuan.  ");
        //
        BannerEntity mainBanner4 = new BannerEntity();
        MultimediaEntity bannerImg4 = new MultimediaEntity();
        bannerImg4.setMultimediaType(MultimediaEnum.IMG);
        bannerImg4.setMultimediaUrl("/home/dataImg/yanfa2.jpg");
        bannerImg4.setDescription("Research and development database");

        mainBanner4.setBannerImg(bannerImg4);
        mainBanner4.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner4.setH5Url("url");
        mainBanner4.setInfoTitle("Industry-university-research expert database");
        mainBanner4.setInfoDescription("We have cooperated with more than ten experts and senior engineers from Qingdao Institute of Bioenergy, ENGLISH Academy of Sciences, Beijing University of Chemical Technology, Ocean University of China and other universities.  ");
        mainBanner4.setInfoContent("");
        rdiInfoEntity.setDatabaseBanner(mainBanner4);
        //
        BannerEntity mainBanner5 = new BannerEntity();
        MultimediaEntity bannerImg5 = new MultimediaEntity();
        bannerImg5.setMultimediaType(MultimediaEnum.IMG);
        bannerImg5.setMultimediaUrl("/home/dataImg/yanfa3.jpg");
        bannerImg5.setDescription("team ");

        mainBanner5.setBannerImg(bannerImg5);
        mainBanner5.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner5.setH5Url("url");
        mainBanner5.setInfoTitle("Industry-university-research expert database");
        mainBanner5.setInfoDescription("We have cooperated with more than ten experts and senior engineers from Qingdao Institute of Bioenergy, ENGLISH Academy of Sciences, Beijing University of Chemical Technology, Ocean University of China and other universities.  ");
        mainBanner5.setInfoContent("");
        rdiInfoEntity.setTeamBanner(mainBanner5);

        BannerEntity mainBanner6 = new BannerEntity();
        MultimediaEntity bannerImg6 = new MultimediaEntity();
        bannerImg6.setMultimediaType(MultimediaEnum.IMG);
        bannerImg6.setMultimediaUrl("/home/dataImg/yanfa4.jpg");
        bannerImg6.setDescription("patent ");

        mainBanner6.setBannerImg(bannerImg6);
        mainBanner6.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner6.setH5Url("url");
        mainBanner6.setInfoTitle("More than 300 kinds of products have been developed and nearly 100 patents have been authorized");
        mainBanner6.setInfoDescription("Now it has a professional formula laboratory, process laboratory, high standard testing center, can carry out tablet, powder, natural capsule, hard capsule, oral liquid and other diversified products formula design, process research, quality standard testing, stability test and other projects of research and development.  With excellent innovation and r & D capability, Realmus has undertaken the national key plan of 13th Five-Year Plan, the development and industrial chain application of characteristic Marine polyunsaturated fatty acids, shandong Industrial chain plan, Shandong Provincial key R & D plan and many other national, provincial and municipal projects.  ");
        mainBanner6.setInfoContent("");
        rdiInfoEntity.setTeamBanner(mainBanner5);

        rdiInfoEntity.setPatentBanner(mainBanner6);
        //4. CNAS实验室
        RDLaboratoryEntity laboratory = new RDLaboratoryEntity();

        BannerEntity mainBanner7 = new BannerEntity();
        MultimediaEntity bannerImg7 = new MultimediaEntity();
        bannerImg7.setMultimediaType(MultimediaEnum.IMG);
        bannerImg7.setMultimediaUrl("/home/dataImg/shiyanshi1.jpg");
        bannerImg7.setDescription("CNAS");

        mainBanner7.setBannerImg(bannerImg7);
        mainBanner7.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner7.setH5Url("url");
        mainBanner7.setInfoTitle("CNAS lab");
        mainBanner7.setInfoDescription("Authoritative certification of high standards of testing ability");
        mainBanner7.setInfoContent("CNAS laboratory accreditation standard testing center equipped with the United States Agilent, Waters, Germany Sekam and other imported R & D testing equipment more than 70 sets of more than 300 items, identification more than 100 items, the development of analysis methods more than 40 items  ");
        laboratory.setMainBanner(mainBanner7);

        BannerEntity mainBanner8 = new BannerEntity();
        MultimediaEntity bannerImg8 = new MultimediaEntity();
        bannerImg8.setMultimediaType(MultimediaEnum.IMG);
        bannerImg8.setMultimediaUrl("/home/dataImg/shiyanshi2.jpg");
        bannerImg8.setDescription("laboratory");

        mainBanner8.setBannerImg(bannerImg8);
        mainBanner8.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner8.setH5Url("url");
        mainBanner8.setInfoTitle("CNAS laboratory accreditation standard testing center");
        mainBanner8.setInfoDescription("Successfully passed CNAS accreditation supervision review and on-site audit, to the first party laboratory accreditation  ");
        mainBanner8.setInfoContent("");
        laboratory.setTestingCenterBanner1(mainBanner8);

        BannerEntity mainBanner9 = new BannerEntity();
        MultimediaEntity bannerImg9 = new MultimediaEntity();
        bannerImg9.setMultimediaType(MultimediaEnum.IMG);
        bannerImg9.setMultimediaUrl("/home/dataImg/shiyanshi3.jpg");
        bannerImg9.setDescription("laboratory");

        mainBanner9.setBannerImg(bannerImg9);
        mainBanner9.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner9.setH5Url("url");
        mainBanner9.setInfoTitle("CNAS laboratory accreditation standard testing center");
        mainBanner9.setInfoDescription("Successfully passed CNAS accreditation supervision review and on-site audit, to the first party laboratory accreditation  ");
        mainBanner9.setInfoContent("");
        laboratory.setTestingCenterBanner2(mainBanner9);

        BannerEntity mainBanner10 = new BannerEntity();
        MultimediaEntity bannerImg10 = new MultimediaEntity();
        bannerImg10.setMultimediaType(MultimediaEnum.IMG);
        bannerImg10.setMultimediaUrl("/home/dataImg/shiyanshi4.jpg");
        bannerImg10.setDescription("laboratory");

        mainBanner10.setBannerImg(bannerImg10);
        mainBanner10.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner10.setH5Url("url");
        mainBanner10.setInfoTitle("More than 400 items were tested");
        mainBanner10.setInfoDescription("");
        mainBanner10.setInfoContent("Phytochemistry identification include more than 70 items, other analysis projects like acid value, peroxide value, vitamins, amino acids, elemental analysis, phytochemistry class efficiency indicators, pesticide residues, mycotoxins, microorganism and so on, annual participation covers the physical and chemical indexes, efficacy components (liquid phase and gas phase), heavy metals, the ability of microorganisms, and other areas of the whole verification plan, are satisfied with.  ");
        laboratory.setTestItemBanner(mainBanner10);


        BannerEntity mainBanner11 = new BannerEntity();
        MultimediaEntity bannerImg11 = new MultimediaEntity();
        bannerImg11.setMultimediaType(MultimediaEnum.IMG);
        bannerImg11.setMultimediaUrl("/home/dataImg/shiyanshi5.jpg");
        bannerImg11.setDescription("实验室");

        mainBanner11.setBannerImg(bannerImg11);
        mainBanner11.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner11.setH5Url("url");
        mainBanner11.setInfoTitle("Equipped with more than 70 sets of imported R & D inspection equipment such as Agilent from the United States and Waters from Germany  ");
        mainBanner11.setInfoDescription("");
        mainBanner11.setInfoContent("With inductively coupled plasma mass spectrometer (ICP-MS), liquid phase mass spectrometer (LC/MS), liquid phase chromatograph (HPLC), gas chromatograph (GC), GC, amino acid analyzer, Swiss Buqi Kessler nitrogen determination instrument, water activity meter, atomic absorption spectrophotometer, RGF-7800 atomic fluorescence spectrophotometer and other advanced detection equipment  Prepare, and intelligent tension machine, roof air body analyzer and other packaging material testing equipment.  ");
        laboratory.setEquipmentBanner(mainBanner11);
        //5.质量管理
        RDQualityEntity quality = new RDQualityEntity();

        BannerEntity mainBanner12 = new BannerEntity();
        MultimediaEntity bannerImg12 = new MultimediaEntity();
        bannerImg12.setMultimediaType(MultimediaEnum.IMG);
        bannerImg12.setMultimediaUrl("/home/dataImg/zhiliang1.jpg");
        bannerImg12.setDescription("quality control");

        mainBanner12.setBannerImg(bannerImg12);
        mainBanner12.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner12.setH5Url("url");
        mainBanner12.setInfoTitle("quality control");
        mainBanner12.setInfoDescription("Excellence and progress never stop");
        mainBanner12.setInfoContent("Strictly abide by a set of strict quality management system, standardize production, the whole process of quality control, strict inspection, from ingredients to finished products to set up a number of key points of quality, to ensure that every product is quality life。");
        quality.setMainBanner(mainBanner12);

        BannerEntity mainBanner13 = new BannerEntity();
        MultimediaEntity bannerImg13 = new MultimediaEntity();
        bannerImg13.setMultimediaType(MultimediaEnum.IMG);
        bannerImg13.setMultimediaUrl("/home/dataImg/zhiliang2.jpg");
        bannerImg13.setDescription("quality control ");

        mainBanner13.setBannerImg(bannerImg13);
        mainBanner13.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner13.setH5Url("url");
        mainBanner13.setInfoTitle("Build the whole chain of quality management system");
        mainBanner13.setInfoDescription("");
        mainBanner13.setInfoContent("From product design, supplier management, production process control, inspection process, product traceability and after-sales management to set up multiple channels of quality control and quality services.  Company consists of automatic production factory to digital, intelligent plant transformation, by MES management system, using visual management mode, through the man-machine material method ring, from the scene monitoring condition, material tracking management, information feedback, quality management, poor accused of ultra early warning and analysis aspects of practice the whole scene at the scene of the dynamic control,  The whole process of product traceability, to ensure the quality of each product life.  Through the interconnection of MES, ERP, WMS, SRM and other systems, to provide reliable manufacturing data management to provide reliable data basis for planning and scheduling, production scheduling, inventory, quality, cost, etc., to achieve lower cost, higher performance, more flexible production and manufacturing capacity, and realize Realmus intelligent manufacturing.  ");
        quality.setQualityBanner(mainBanner13);


        BannerEntity mainBanner14 = new BannerEntity();
        MultimediaEntity bannerImg14 = new MultimediaEntity();
        bannerImg14.setMultimediaType(MultimediaEnum.IMG);
        bannerImg14.setMultimediaUrl("/home/dataImg/zhiliang3.jpg");
        bannerImg14.setDescription("quality control");

        mainBanner14.setBannerImg(bannerImg14);
        mainBanner14.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner14.setH5Url("url");
        mainBanner14.setInfoTitle("Integrated intelligent operation management platform");
        mainBanner14.setInfoDescription("");
        mainBanner14.setInfoContent("Based on modern lean management concept and relying on new generation technologies such as artificial intelligence, mobile Internet of Things, big data and cloud, SRM supplier management platform reshaps Realmus' huge supplier network and optimizes supplier relationship management.  Efficient coordination between internal and external enterprises, rapid delivery and receipt of goods, real-time visibility of the overall progress, online checking of unreconciled details, establishment of statements, financial verification, accurate and efficient reconciliation, to create a harmonious business ecology and corporate interests community.  At the same time, through logistics, business flow, capital flow and information flow \"four streams in one\", to achieve integrated intelligent operation of enterprises.  ");
        quality.setPlatformBanner(mainBanner14);


        BannerEntity mainBanner15 = new BannerEntity();
        MultimediaEntity bannerImg15 = new MultimediaEntity();
        bannerImg15.setMultimediaType(MultimediaEnum.IMG);
        bannerImg15.setMultimediaUrl("/home/dataImg/zhiliang4.jpg");
        bannerImg15.setDescription("quality control");

        mainBanner15.setBannerImg(bannerImg15);
        mainBanner15.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner15.setH5Url("url");
        mainBanner15.setInfoTitle("Intelligent logistics management system");
        mainBanner15.setInfoDescription("");
        mainBanner15.setInfoContent("Through intelligent logistics system effective connection of various kinds of intelligent equipment, the mobile terminal, the enterprise management system, universal coverage receiving, inspection, warehousing, led/materials development, sales, outbound, transfers, inventory and other business processes, to achieve internal logistics, mobile, transparency, the lean and intelligent management of four modernizations, so as to improve efficiency, reduce costs, increase efficiency, strengthen the industry competitiveness  ");
        quality.setLogisticsBanner(mainBanner15);


        //更新
        rdEntity.setRdQuality(quality);
        rdEntity.setRdLaboratory(laboratory);
        rdEntity.setBanner(bannerEntity);
        rdEntity.setIntelligentPlant(intelligentPlant);
        rdEntity.setRdiInfo(rdiInfoEntity);

        navigationEntity.setExtension(rdEntity);
        navigationService.updateNavigationInfo(LanguageEnum.ENGLISH, navigationEntity);
    }

    /**
     * 更新 产品中心 数据
     */
    @Test
    public void updatePRODUCTEntityInfo() {
        //1. 查询数据
        NavigationEntity<RDEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.ENGLISH, ExtendTypeEnum.PRODUCT.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        RDEntity rdEntity = new RDEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("/home/dataImg/banner4.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("产品中心banner");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("/products");
        bannerEntity.setInfoTitle("product center");
        bannerEntity.setInfoDescription("Do a respected enterprise, do a conscience quality products");
        bannerEntity.setInfoContent("");

        rdEntity.setBanner(bannerEntity);
        //更新
        navigationEntity.setExtension(rdEntity);
        navigationService.updateNavigationInfo(LanguageEnum.ENGLISH, navigationEntity);
    }


    /**
     * 更新 品牌中心 数据
     */
    @Test
    public void updateBrandEntityInfo() {
        //1. 查询数据
        NavigationEntity<BrandEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.ENGLISH, ExtendTypeEnum.BRAND.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        BrandEntity brandEntity = new BrandEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("/home/dataImg/banner6.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("Brand Center Banner  ");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("url");
        bannerEntity.setInfoTitle("Brand Center");
        bannerEntity.setInfoDescription("Precise nutrition, health and energy");
        bannerEntity.setInfoContent("");

        brandEntity.setBanner(bannerEntity);
        //更新
        navigationEntity.setExtension(brandEntity);
        navigationService.updateNavigationInfo(LanguageEnum.ENGLISH, navigationEntity);
    }


    /**
     * 更新 外贸出口 数据
     */
    @Test
    public void updateForeignEntityInfo() {
        //1. 查询数据
        NavigationEntity<BrandEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.ENGLISH, ExtendTypeEnum.FOREIGN.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        BrandEntity brandEntity = new BrandEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("/home/dataImg/banner5.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("Export banner  ");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("/export");
        bannerEntity.setInfoTitle("foreign trade export ");
        bannerEntity.setInfoDescription("From China, to the world");
        bannerEntity.setInfoContent("");

        brandEntity.setBanner(bannerEntity);
        //更新
        navigationEntity.setExtension(brandEntity);
        navigationService.updateNavigationInfo(LanguageEnum.ENGLISH, navigationEntity);
    }


    /**
     * 更新 联系我们 数据
     */
    @Test
    public void updateContactUsEntityInfo() {
        //1. 查询数据
        NavigationEntity<BrandEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.ENGLISH, ExtendTypeEnum.CONTACT_US.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        BrandEntity brandEntity = new BrandEntity();
        BannerEntity bannerEntity = new BannerEntity();
        MultimediaEntity multimediaEntity = new MultimediaEntity();
        multimediaEntity.setMultimediaUrl("/home/dataImg/banner7.jpg");
        multimediaEntity.setMultimediaType(MultimediaEnum.IMG);
        multimediaEntity.setDescription("Contact us banner  ");
        bannerEntity.setBannerImg(multimediaEntity);

        bannerEntity.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        bannerEntity.setH5Url("/contactus");
        bannerEntity.setInfoTitle("Contact us");
        bannerEntity.setInfoDescription("A great story, starting with a message here");
        bannerEntity.setInfoContent("");

        brandEntity.setBanner(bannerEntity);
        //更新
        navigationEntity.setExtension(brandEntity);
        navigationService.updateNavigationInfo(LanguageEnum.ENGLISH, navigationEntity);
    }


}