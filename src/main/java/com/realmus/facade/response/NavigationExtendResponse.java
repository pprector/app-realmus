package com.realmus.facade.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * realmus.com
 *
 * @Author hkpeng
 * @Description 导航栏详情数据返回  总对象
 * @Date 2022/1/1 17:07
 * @Version 1.0
 */
@Setter
@Getter
@ToString
@ApiModel(value = "导航扩展信息 大类")
public class NavigationExtendResponse {
    @ApiModelProperty(example = "首页数据")
    private  NavHomeResponse  home;

    @ApiModelProperty(example = "关于我们数据")
    private NavAboutUsResponse aboutUs;

    @ApiModelProperty(example = "新闻中心数据")
    private  NewsResponse news;

    @ApiModelProperty(example = "智造研发")
    private NavRDResponse rd;

    @ApiModelProperty(example = "产品中心")
    private NvaProductResponse product;

    @ApiModelProperty(example = "品牌中心")
    private NavBrandResponse brand;

    @ApiModelProperty(example = "外贸出口")
    private NavForeignResponse foreign;

    @ApiModelProperty(example = "联系我们")
    private  NavContactUsResponse contactUs;


}
