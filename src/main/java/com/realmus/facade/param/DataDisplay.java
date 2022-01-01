package com.realmus.facade.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/30 - 10:50
 */
@Setter
@Getter
@ToString
public class DataDisplay {
    /**
     * 数据展示背景图片
     */
    @ApiModelProperty(example = "数据展示背景图片")
    private String bgImg;

    @ApiModelProperty(example = "数据展示集合")
    private List<DataDetails> dataDetailsList;
}
