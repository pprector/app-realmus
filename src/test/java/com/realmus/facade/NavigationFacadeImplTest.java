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
     * 更新 智造研发 数据
     */
    @Test
    public void updateRDEntityInfo() {
        // 查询数据
        NavigationEntity<RDEntity> navigationEntity = navigationRepository.findExtendInfo(LanguageEnum.CHINESE, ExtendTypeEnum.RD.getId());
        System.out.println(JSON.toJSONString(navigationEntity, true));
        //数据封装
        //1.通用banner
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


        //2.智能工厂数据
        RDIntelligentPlantEntity intelligentPlant = new RDIntelligentPlantEntity();
        //2.1 主banner
        BannerEntity mainBanner = new BannerEntity();
        MultimediaEntity bannerImg1 = new MultimediaEntity();
        bannerImg1.setMultimediaType(MultimediaEnum.IMG);
        bannerImg1.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/banner10.jpg");
        bannerImg1.setDescription("研发工厂");

        mainBanner.setBannerImg(bannerImg1);
        mainBanner.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner.setH5Url("url");
        mainBanner.setInfoTitle("智能工厂");
        mainBanner.setInfoDescription("智能▪智造 全新工艺技术助推工业4.0精益生产");
        mainBanner.setInfoContent("智设备、智生产、智创造从传统工厂到智能化工厂方向发展，运用产品数字化、生产数字化、设备数字化、管理数据化，以实现“6个1”数字化管理目标：即管理好每1位员工→管理好每1个订单→管理好每1种物料→管理好每1道工序→管理好每1台设备→管理好每1笔资金，生产管理更精细、更透明、更柔性！");

        BannerEntity factoryBanner = new BannerEntity();
        MultimediaEntity bannerImg2 = new MultimediaEntity();
        bannerImg2.setMultimediaType(MultimediaEnum.IMG);
        bannerImg2.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/banner11.jpg");
        bannerImg2.setDescription("研发工厂");
        //详情
        factoryBanner.setBannerImg(bannerImg2);
        factoryBanner.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        factoryBanner.setH5Url("url");
        factoryBanner.setInfoTitle("智设备、智生产、智创造");
        factoryBanner.setInfoDescription("");
        factoryBanner.setInfoContent("智设备、智生产、智创造从传统工厂到智能化工厂方向发展，运用产品数字化、生产数字化、设备数字化、管理数据化，以实现“6个1”数字化管理目标：即管理好每1位员工→管理好每1个订单→管理好每1种物料→管理好每1道工序→管理好每1台设备→管理好每1笔资金，生产管理更精细、更透明、更柔性！");
        //3 工厂视频集合
        List<VideoEntity> videoList = new ArrayList<>();

        VideoEntity videoEntity1 = new VideoEntity();
        videoEntity1.setCoverImgUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg1.jpg");
        videoEntity1.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity1.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg1.mp4");
        videoEntity1.setDescription("潮流好营养的饮品生产工厂");

        VideoEntity videoEntity2 = new VideoEntity();
        videoEntity2.setCoverImgUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg2.jpg");
        videoEntity2.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity2.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg2.mp4");
        videoEntity2.setDescription("创新功能型软硬胶囊生产工厂");

        VideoEntity videoEntity3 = new VideoEntity();
        videoEntity3.setCoverImgUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg3.jpg");
        videoEntity3.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity3.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg3.mp4");
        videoEntity3.setDescription("功能科技感的运营营养生产工厂");

        VideoEntity videoEntity4 = new VideoEntity();
        videoEntity4.setCoverImgUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg4.jpg");
        videoEntity4.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity4.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg4.mp4");
        videoEntity4.setDescription("好吃零食化的片剂工厂");

        VideoEntity videoEntity5 = new VideoEntity();
        videoEntity5.setCoverImgUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg5.jpg");
        videoEntity5.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity5.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg5.mp4");
        videoEntity5.setDescription("简约不简单的粉剂工厂");

        VideoEntity videoEntity6 = new VideoEntity();
        videoEntity6.setCoverImgUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg6.jpg");
        videoEntity6.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity6.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg6.mp4");
        videoEntity6.setDescription("科学营养化的特膳食品生产工厂");

        VideoEntity videoEntity7 = new VideoEntity();
        videoEntity7.setCoverImgUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg7.jpg");
        videoEntity7.setMultimediaType(MultimediaEnum.VIDEO);
        videoEntity7.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/video/vimg7.mp4");
        videoEntity7.setDescription("严谨智能化的益生菌生产工厂");

        videoList.add(videoEntity7);
        videoList.add(videoEntity6);
        videoList.add(videoEntity5);
        videoList.add(videoEntity4);
        videoList.add(videoEntity3);
        videoList.add(videoEntity2);
        videoList.add(videoEntity1);

        intelligentPlant.setVideoList(videoList);
        intelligentPlant.setFactoryBanner(factoryBanner);
        intelligentPlant.setMainBanner(mainBanner);

        //3. 研发创新模块
        RDIInfoEntity rdiInfoEntity = new RDIInfoEntity();


        BannerEntity mainBanner3 = new BannerEntity();
        MultimediaEntity bannerImg3 = new MultimediaEntity();
        bannerImg3.setMultimediaType(MultimediaEnum.IMG);
        bannerImg3.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/yanfa1.jpg");
        bannerImg3.setDescription("研发创新");

        mainBanner3.setBannerImg(bannerImg3);
        mainBanner3.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner3.setH5Url("url");
        mainBanner3.setInfoTitle("研发创新");
        mainBanner3.setInfoDescription("专业▪专注 刷新营养保健食品新标准");
        mainBanner3.setInfoContent("与国内外多家院校长期合作，每年科研投入达2000余万元；年研发产品超过300种以上，授权专利近百项");

        rdiInfoEntity.setMainBanner(mainBanner3);
        //3.2 头
        rdiInfoEntity.setHeadLine("研发创新持续突破");
        rdiInfoEntity.setDescription(" 注重产学研协同发展，与国内外多家院校长期合作，拥有集咨询、研发、销售于一体的国内外知名专业智囊团队，每年科研投入达2000万元。");
        //
        BannerEntity mainBanner4 = new BannerEntity();
        MultimediaEntity bannerImg4 = new MultimediaEntity();
        bannerImg4.setMultimediaType(MultimediaEnum.IMG);
        bannerImg4.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/yanfa2.jpg");
        bannerImg4.setDescription("研发数据库");

        mainBanner4.setBannerImg(bannerImg4);
        mainBanner4.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner4.setH5Url("url");
        mainBanner4.setInfoTitle("产学研专家数据库");
        mainBanner4.setInfoDescription("与中国科学院青岛生物能源研究所、北京化工大学、中国海洋大学等多所高校的十余位专家及高级工程师合作。");
        mainBanner4.setInfoContent("");
        rdiInfoEntity.setDatabaseBanner(mainBanner4);
        //
        BannerEntity mainBanner5 = new BannerEntity();
        MultimediaEntity bannerImg5 = new MultimediaEntity();
        bannerImg5.setMultimediaType(MultimediaEnum.IMG);
        bannerImg5.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/yanfa3.jpg");
        bannerImg5.setDescription("团队");

        mainBanner5.setBannerImg(bannerImg5);
        mainBanner5.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner5.setH5Url("url");
        mainBanner5.setInfoTitle("产学研专家数据库");
        mainBanner5.setInfoDescription("与中国科学院青岛生物能源研究所、北京化工大学、中国海洋大学等多所高校的十余位专家及高级工程师合作。");
        mainBanner5.setInfoContent("");
        rdiInfoEntity.setTeamBanner(mainBanner5);

        BannerEntity mainBanner6 = new BannerEntity();
        MultimediaEntity bannerImg6 = new MultimediaEntity();
        bannerImg6.setMultimediaType(MultimediaEnum.IMG);
        bannerImg6.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/yanfa4.jpg");
        bannerImg6.setDescription("专利");

        mainBanner6.setBannerImg(bannerImg6);
        mainBanner6.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner6.setH5Url("url");
        mainBanner6.setInfoTitle("年研发产品超过300种以上，授权专利近百项");
        mainBanner6.setInfoDescription("现已拥有专业的配方实验室、工艺实验室，高标准的检测中心，可开展片剂、粉剂、然胶囊、硬胶囊、口服液等多样化产品的配方设计、工艺研究、质量标准检测、稳定性实验等项目的研究开发。\n" +
                "\n" +
                "百合股份凭借优异的创新研发能力，先后承单国家十三五重点计划，特色海洋多不饱和脂肪酸的开发及产业链应用，山东省产业链计划、山东省重点研发计划等多项国家、省市级项目研发。。");
        mainBanner6.setInfoContent("");
        rdiInfoEntity.setTeamBanner(mainBanner5);

        rdiInfoEntity.setPatentBanner(mainBanner6);
        //4. CNAS实验室
        RDLaboratoryEntity laboratory = new RDLaboratoryEntity();

        BannerEntity mainBanner7 = new BannerEntity();
        MultimediaEntity bannerImg7 = new MultimediaEntity();
        bannerImg7.setMultimediaType(MultimediaEnum.IMG);
        bannerImg7.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/shiyanshi1.jpg");
        bannerImg7.setDescription("实验室");

        mainBanner7.setBannerImg(bannerImg7);
        mainBanner7.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner7.setH5Url("url");
        mainBanner7.setInfoTitle("CNAS实验室");
        mainBanner7.setInfoDescription("权威认证 高标准检测能力");
        mainBanner7.setInfoContent("CNAS实验室认可标准的检测中心\n" +
                "配备美国Agilent、waters、德国塞卡姆等进口研发检验设备70余台套\n" +
                "检测项目超过300余项、鉴定100余项、开发分析方法40余项");
        laboratory.setMainBanner(mainBanner7);

        BannerEntity mainBanner8 = new BannerEntity();
        MultimediaEntity bannerImg8 = new MultimediaEntity();
        bannerImg8.setMultimediaType(MultimediaEnum.IMG);
        bannerImg8.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/shiyanshi2.jpg");
        bannerImg8.setDescription("实验室");

        mainBanner8.setBannerImg(bannerImg8);
        mainBanner8.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner8.setH5Url("url");
        mainBanner8.setInfoTitle("CNAS实验室认可标准的检测中心");
        mainBanner8.setInfoDescription("顺利通过CNAS认可监督评审及现场审核，以第一方实验室获得认可资格");
        mainBanner8.setInfoContent("");
        laboratory.setTestingCenterBanner1(mainBanner8);

        BannerEntity mainBanner9 = new BannerEntity();
        MultimediaEntity bannerImg9 = new MultimediaEntity();
        bannerImg9.setMultimediaType(MultimediaEnum.IMG);
        bannerImg9.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/shiyanshi3.jpg");
        bannerImg9.setDescription("实验室");

        mainBanner9.setBannerImg(bannerImg9);
        mainBanner9.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner9.setH5Url("url");
        mainBanner9.setInfoTitle("CNAS实验室认可标准的检测中心");
        mainBanner9.setInfoDescription("顺利通过CNAS认可监督评审及现场审核，以第一方实验室获得认可资格");
        mainBanner9.setInfoContent("");
        laboratory.setTestingCenterBanner2(mainBanner9);

        BannerEntity mainBanner10 = new BannerEntity();
        MultimediaEntity bannerImg10 = new MultimediaEntity();
        bannerImg10.setMultimediaType(MultimediaEnum.IMG);
        bannerImg10.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/shiyanshi4.jpg");
        bannerImg10.setDescription("实验室");

        mainBanner10.setBannerImg(bannerImg10);
        mainBanner10.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner10.setH5Url("url");
        mainBanner10.setInfoTitle("检测项目超过400余项");
        mainBanner10.setInfoDescription("");
        mainBanner10.setInfoContent("包含植提鉴别70余项，其他分析类项目酸价、过氧化值、维生素类、元素分析类、氨基酸类、植提类功效指标、农残、真菌毒素类、微生物类等，每年度参与覆盖理化指标、功效成分（液相、气相）、重金属、微生物等全领域的能力验证计划，均满意通过。");
        laboratory.setTestItemBanner(mainBanner10);


        BannerEntity mainBanner11 = new BannerEntity();
        MultimediaEntity bannerImg11 = new MultimediaEntity();
        bannerImg11.setMultimediaType(MultimediaEnum.IMG);
        bannerImg11.setMultimediaUrl("https://realmus.oss-cn-hongkong.aliyuncs.com/home/dataImg/shiyanshi5.jpg");
        bannerImg11.setDescription("实验室");

        mainBanner11.setBannerImg(bannerImg11);
        mainBanner11.setInfoType(ModuleEnum.ADVANTAGE_BANNER);
        mainBanner11.setH5Url("url");
        mainBanner11.setInfoTitle("配备美国Agilent、waters\n" +
                "德国塞卡姆等\n" +
                "进口研发检验设备70余台套");
        mainBanner11.setInfoDescription("");
        mainBanner11.setInfoContent("拥有电感耦合等离子体质谱仪（ICP-MS）、液相质谱仪（LC/MS）、液相色谱仪（HPLC）、气相色谱仪（GC）、气质联用仪、氨基酸分析仪、瑞士步琪凯氏定氮仪、水活度测定仪、原子吸收分光光度计、RGF-7800原子荧光分光光度计等先进检测设备，及智能拉力机、顶空气体分析仪等包材检测设备。");
        laboratory.setEquipmentBanner(mainBanner10);

        //更新
        rdEntity.setRdLaboratory(laboratory);
        rdEntity.setBanner(bannerEntity);
        rdEntity.setIntelligentPlant(intelligentPlant);
        rdEntity.setRdiInfo(rdiInfoEntity);

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