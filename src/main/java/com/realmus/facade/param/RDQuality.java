package com.realmus.facade.param;

import com.realmus.domain.entity.BannerEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 制造研发 - 质量管理
 * @date 2021/12/30 - 14:51
 */
@Setter
@Getter
@ToString
public class RDQuality {
    /**
     * 主 banner
     */
    @ApiModelProperty(example = "质量管理 主 banner")
    private Banner mainBanner;
    /**
     * 质量管理描述
     */
    @ApiModelProperty(example = "质量管理描述 banner")
    private Banner qualityBanner;

    /**
     * 质量管理 平台
     */
    @ApiModelProperty(example = "质量管理 平台banner")
    private Banner platformBanner;

    /**
     * 质量管理 物流
     */
    @ApiModelProperty(example = "质量管理 物流 banner")
    private Banner logisticsBanner;
}
