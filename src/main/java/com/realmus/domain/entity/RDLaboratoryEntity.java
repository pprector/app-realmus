package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 制造研发 - 实验室数据
 * @date 2021/12/29 - 11:09
 */
@ToString
@Getter
@Setter
public class RDLaboratoryEntity {
    /**
     * 检测中心
     */
    private BannerEntity testingCenterBanner;

    /**
     * 检测项目
     */
    private BannerEntity testItemBanner;

    /**
     * 检测中心
     */
    private BannerEntity equipmentBanner;


}
