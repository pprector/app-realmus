package com.realmus.facade.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author hkpeng
 * @date 2022/3/8 - 14:02
 */
@Setter
@Getter
@ToString
@ApiModel(value = "查询产品", description = "查询产品请求参数类")
public class SearchRequest {

    @ApiModelProperty(example = "搜索信息-分类或产品名称")
    private String inputInfo;
}
