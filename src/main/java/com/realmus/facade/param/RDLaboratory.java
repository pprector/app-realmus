package com.realmus.facade.param;

import com.realmus.domain.entity.BannerEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 制造研发 - 实验室数据
 * @date 2021/12/30 - 14:46
 */
@Setter
@Getter
@ToString
public class RDLaboratory {
    /**
     * 主banner
     */
    @ApiModelProperty(example = "主信息 实验室 banner")
    private Banner mainBanner;
    /**
     * 检测中心
     */
    @ApiModelProperty(example = "检测中心1 banner")
    private Banner testingCenterBanner1;
    /**
     * 检测中心
     */
    @ApiModelProperty(example = "检测中心2 banner")
    private Banner testingCenterBanner2;

    /**
     * 检测项目
     */
    @ApiModelProperty(example = "检测项目 banner")
    private Banner testItemBanner;

    /**
     * 检测设备
     */
    @ApiModelProperty(example = "检测设备 banner")
    private Banner equipmentBanner;


}
