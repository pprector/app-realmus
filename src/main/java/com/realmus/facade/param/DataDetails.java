package com.realmus.facade.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 数据展示明细信息
 * @date 2021/12/30 - 10:53
 */
@Setter
@Getter
@ToString
public class DataDetails {
    /**
     * 数值
     */
    @ApiModelProperty(example = "数值")
    private String number;
    /**
     * 计量单位
     */
    @ApiModelProperty(example = "计量单位")
    private String units;
    /**
     * 数据 描述
     */
    @ApiModelProperty(example = "描述信息")
    private String desc;
}
