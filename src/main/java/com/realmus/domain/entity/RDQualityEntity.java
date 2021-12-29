package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 制造研发 - 质量管理模块
 * @date 2021/12/29 - 11:18
 */
@Setter
@Getter
@ToString
public class RDQualityEntity {
    /**
     * 主 banner
     */
    private BannerEntity mainBanner;
    /**
     * 质量管理描述
     */
    private BannerEntity qualityBanner;

    /**
     * 质量管理 平台
     */
    private BannerEntity platformBanner;

    /**
     * 质量管理 物流
     */
    private BannerEntity logisticsBanner;

}
