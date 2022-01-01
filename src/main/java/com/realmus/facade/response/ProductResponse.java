package com.realmus.facade.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hkpeng
 * 产品信息返回数据
 * @date 2021/12/29 - 16:43
 */
@Setter
@Getter
@ToString
public class ProductResponse {

    /**
     * 产品id
     */
    @ApiModelProperty(example = "产品id")
    private String id;
    /**
     * 产品名称
     */
    @ApiModelProperty(example = "产品名称-一级分类-二级分类")
    private String proName;
    /**
     * 该分类下 实体
     */
    @ApiModelProperty(example = "产品名称-一级分类-二级分类")
    private List<ProductResponse> subset;
    /**
     * 原料
     */
    @ApiModelProperty(example = "原料")
    private String Ingredient;
    /**
     * 描述信息
     */
    @ApiModelProperty(example = "描述信息")
    private String desc;
    /**
     * 产品图片集合
     */
    @ApiModelProperty(example = "产品图片")
    private String imgUrl;
}
