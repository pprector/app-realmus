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
public class Banner extends PublicInfo {
    @ApiModelProperty(example = "信息模块图片获取地址")
    private Img img;
}
