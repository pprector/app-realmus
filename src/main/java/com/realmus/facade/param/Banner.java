package com.realmus.facade.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.swing.*;

/**
 * @author hkpeng
 * 轮播返回对象
 * @date 2021/12/22 - 11:54
 */

@Setter
@Getter
@ToString
public class Banner {
    @ApiModelProperty(example = "信息Id")
    private String infoId;

    @ApiModelProperty(example = "信息模块Code")
    private Integer infoType;

    @ApiModelProperty(example = "信息模块链接地址")
    private String h5Url;

    @ApiModelProperty(example = "信息模块图片获取地址")
    private String imgUrl;

    @ApiModelProperty(example = "信息 标题头")
    private String infoTitle;

    @ApiModelProperty(example = "信息 描述 ")
    private String infoDescription;

    @ApiModelProperty(example = "信息 内容")
    private String infoContent;


}
