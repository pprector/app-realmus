package com.realmus.facade.response;

import com.realmus.domain.entity.MultimediaEntity;
import com.realmus.domain.entity.ProductInfoEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/29 - 16:43
 */
@Setter
@Getter
@ToString
public class ProductResponse {

    /**
     * 产品名称
     */
    @ApiModelProperty(example = "产品名称 ")
    private String productName;
    /**
     * 产品一级
     */
    @ApiModelProperty(example = "产品一级名称 ")
    private String ProductLv1Name;
    /**
     * 产品二级
     */
    @ApiModelProperty(example = "产品二级名称 ")
    private String ProductLv2Name;
    /**
     * 原料
     */
    @ApiModelProperty(example = "原料 ")
    private String Ingredient;
    /**
     * 功能简要
     */
    @ApiModelProperty(example = "功能简要 ")
    private String description;
    /**
     * 产品图片
     */
    @ApiModelProperty(example = "产品名称 ")
    private List<String> multimediaUrlList;
}
