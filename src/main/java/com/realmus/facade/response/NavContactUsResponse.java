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
 * @Description 联系我们
 * @Date 2022/1/1 17:18
 * @Version 1.0
 */
@Setter
@Getter
@ToString
@ApiModel(value = "联系我们 信息")
public class NavContactUsResponse {
    @ApiModelProperty(example = "联系我们 banner")
    private Banner banner;
}
