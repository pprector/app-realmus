package com.realmus.facade.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/23 - 15:15
 */
@Setter
@Getter
@ToString
public class PublicInfo {


    @ApiModelProperty(example = "信息模块链接地址")
    private String h5Url;

    @ApiModelProperty(example = "信息 标题头")
    private String title;

    @ApiModelProperty(example = "信息 描述 ")
    private String desc;

    @ApiModelProperty(example = "信息 内容")
    private String content;
}
