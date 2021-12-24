package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/22 - 14:24
 */
@Setter
@Getter
@ToString
public class HomeInfoEntity {

    /**
     * 模块 轮播图 数据
     */
    private List<BannerEntity> bannerList;
    /**
     * 模块2 公司简介  视频介绍
     */
    private CompanyEntity company;
    /**
     * 模块三 小Banner
     */
    private List<BannerEntity> advantageBanner;
}
