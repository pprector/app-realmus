package com.realmus.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author hkpeng
 * @date 2021/12/16 - 17:40
 */
@ToString
@Getter
@Setter
@ApiModel(value = "基础返回类", description = "基础返回类")
public class ResultModel<T> implements Serializable {
    private static final long serialVersionId = 1L;
    /**
     * 成功状态
     */
    @ApiModelProperty(example = "1:成功,0:失败")
    private Integer status;
    /**
     * 数据
     */
    @ApiModelProperty(example = "返回数据对象")
    private T result;
    /**
     * 错误信息
     */
    @ApiModelProperty(example = "错误信息")
    private String message;

}
