package com.realmus.facade.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author hkpeng
 * @date 2021/12/30 - 15:25
 */
@Setter
@Getter
@ToString
public class PagingRequest {

    @ApiModelProperty(example = "查询当前起始页")
    @NotNull(message = "当前页码不能为空")
    private Integer page;

    @ApiModelProperty(example = "查询行数")
    @NotNull(message = "查询行数不能为空")
    private Integer rows;
}
