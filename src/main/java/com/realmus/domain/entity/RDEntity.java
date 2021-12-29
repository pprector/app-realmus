package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 制造与研发   实体类
 * @date 2021/12/28 - 14:56
 */
@ToString
@Getter
@Setter
public class RDEntity {
    /**
     * 轮播 Banner
     */
    private BannerEntity banner;
    /**
     * RD 详情之 智能工厂
     */
    private RDIntelligentPlantEntity intelligentPlant;
    /**
     * 研发创新模块
     */
    private RDIInfoEntity rdiInfo;
    /**
     * CNAS 实验室
     */
    private RDLaboratoryEntity rdLaboratory;

    /**
     * CNAS 质量管理
     */
    private RDQualityEntity rdQuality;


}
