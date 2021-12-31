package com.realmus.common.util;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/31 - 16:10
 */

public class PageResult<T> {

    @ApiModelProperty(example = "查询当前起始页")
    private Integer page;

    @ApiModelProperty(example = "查询行数")
    private Integer rows;

    @ApiModelProperty(example = "数据总记录数")
    private Integer totalCount;

    @ApiModelProperty(example = "数据总页数")
    private Integer totalPage;

    @ApiModelProperty(example = "数据")
    private List<T> data;

}
