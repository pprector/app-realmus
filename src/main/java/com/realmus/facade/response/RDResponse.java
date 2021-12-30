package com.realmus.facade.response;

import com.realmus.facade.param.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 制造研发 全量数据获取
 * @date 2021/12/30 - 14:36
 */
@Setter
@Getter
@ToString
public class RDResponse {
    /**
     * 轮播 Banner
     */
    @ApiModelProperty(example = "主 Banner ")
    private Banner banner;
    /**
     * RD 详情之 智能工厂
     */
    @ApiModelProperty(example = "RD 详情之 智能工厂 ")
    private RDIntelligentPlant intelligentPlant;
    /**
     * 研发创新模块
     */
    @ApiModelProperty(example = "主 Banner ")
    private RDIInfo rdiInfo;
    /**
     * CNAS 实验室
     */
    @ApiModelProperty(example = "主 Banner ")
    private RDLaboratory rdLaboratory;

    /**
     * CNAS 质量管理
     */
    @ApiModelProperty(example = "主 Banner ")
    private RDQuality rdQuality;
}
