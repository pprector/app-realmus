package com.realmus.facade.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/23 - 15:17
 */
@Setter
@Getter
@ToString
public class Company extends PublicInfo {
    /**
     * 背景图
     */
    @ApiModelProperty(example = "背景图")
    private String bgImg;

    /**
     * 背景图
     */
    @ApiModelProperty(example = "视频地址")
    private String promotionalMp4;


    /**
     * 背景图
     */
    @ApiModelProperty(example = "视频封面图")
    private String videoBgImg;
}
