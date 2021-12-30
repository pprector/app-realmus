package com.realmus.facade.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 分页查询统一 返回参数
 * @date 2021/12/30 - 15:27
 */
@Setter
@Getter
@ToString
public class PagingResponse {
    @ApiModelProperty(example = "查询当前起始页")
    private Integer page;

    @ApiModelProperty(example = "查询行数")
    private Integer rows;

    @ApiModelProperty(example = "数据总记录数")
    private Integer totalCount;

    @ApiModelProperty(example = "数据总页数")
    private Integer totalPage;

}
