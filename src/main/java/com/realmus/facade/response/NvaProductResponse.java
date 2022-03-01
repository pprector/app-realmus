package com.realmus.facade.response;

import com.realmus.facade.param.Banner;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * realmus.com
 *
 * @Author hkpeng
 * @Description 产品中心
 * @Date 2022/1/1 17:14
 * @Version 1.0
 */
@Setter
@Getter
@ToString
@ApiModel(value = "产品模块 信息")
public class NvaProductResponse {
    @ApiModelProperty(example = "产品模块 banner")
    private Banner banner;
}
