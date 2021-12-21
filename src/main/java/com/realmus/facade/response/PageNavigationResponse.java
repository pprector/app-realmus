package com.realmus.facade.response;

import com.realmus.facade.param.Navigation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author hkpeng
 * 导航栏数据获取返回参
 * @date 2021/12/21 - 10:06
 */

@Setter
@Getter
@ToString
public class PageNavigationResponse {

    /**
     * 导航栏ID
     */
    @ApiModelProperty(example = "导航栏ID")
    private String navigationId;
    /**
     * 导航栏名称
     */
    @ApiModelProperty(example = "导航栏名称")
    private String navigationName;
    /**
     * 跳转地址
     */
    @ApiModelProperty(example = "ht跳转地址")
    private String h5Url;
    /**
     * 导航层级
     */
    @ApiModelProperty(example = "导航栏层级")
    private Integer navigationTier;
    /**
     * 子导航栏
     */
    @ApiModelProperty(example = "子导航栏集合")
    List<Navigation> sonNavigationList;

}
