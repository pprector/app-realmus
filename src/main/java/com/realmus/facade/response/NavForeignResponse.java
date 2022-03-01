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
 * @Description 外贸出口
 * @Date 2022/1/1 17:17
 * @Version 1.0
 */
@Setter
@Getter
@ToString
@ApiModel(value = "外贸出口 信息")
public class NavForeignResponse {
    @ApiModelProperty(example = "外贸出口 banner")
    private Banner banner;
}
