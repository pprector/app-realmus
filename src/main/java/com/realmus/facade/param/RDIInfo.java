package com.realmus.facade.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/30 - 14:45
 */
@Setter
@Getter
@ToString
public class RDIInfo {
    /**
     * 主 bannner
     */
    @ApiModelProperty(example = "主 bannner")
    private Banner mainBanner;

    /**
     * 研发标题
     */
    @ApiModelProperty(example = " 研发标题")
    private String headLine;
    /**
     * 研发描述
     */
    @ApiModelProperty(example = " 研发描述")
    private String desc;
    /**
     * banner
     */
    @ApiModelProperty(example = " 数据 banner")
    private Banner dataBanner;
    /**
     * banner
     */
    @ApiModelProperty(example = " 团队 banner")
    private Banner teamBanner;
    /**
     * banner
     */
    @ApiModelProperty(example = " 设备 banner")
    private Banner patentBanner;
}
