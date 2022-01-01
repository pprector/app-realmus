package com.realmus.facade.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 导航栏 数据
 * @date 2021/12/21 - 10:17
 */

@Setter
@Getter
@ToString
public class Navigation {
    /**
     * 导航栏ID
     */
    @ApiModelProperty(example = "子导航栏ID")
    private String id;
    /**
     * 导航栏名称
     */
    @ApiModelProperty(example = "子导航栏名称")
    private String navName;
    /**
     * 跳转地址
     */
    @ApiModelProperty(example = "子导航栏跳转地址")
    private String h5Url;
    /**
     * 导航层级
     */
    @ApiModelProperty(example = "子导航栏层级")
    private Integer navTier;
}
