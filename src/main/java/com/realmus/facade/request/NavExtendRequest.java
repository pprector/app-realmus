package com.realmus.facade.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * realmus.com
 *
 * @Author hkpeng
 * @Description TODO
 * @Date 2022/1/1 17:22
 * @Version 1.0
 */
@Setter
@Getter
@ToString
@ApiModel(value="获取导航栏对象",description="请求参数类" )
public class NavExtendRequest {
    @ApiModelProperty(example = "导航栏Id")
    @NotNull(message = "导航栏Id 不可为空")
    private String navId;
}
