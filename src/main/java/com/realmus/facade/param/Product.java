package com.realmus.facade.param;

import com.realmus.domain.entity.ProductInfoEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Setter
@Getter
@ToString
public class Product {

    /**
     * 产品id
     *
     */
    @ApiModelProperty(example = "产品ID")
    private String productId;
    /**
     * 产品父id
     *
     */
    @ApiModelProperty(example = "产品父ID")
    private String productParentId;
    /**
     * 产品名称
     */
    @ApiModelProperty(example = "产品名称")
    private String productName;

    /**
     * 原料
     */
    @ApiModelProperty(example = "原料")
    private String Ingredient;
    /**
     * 描述信息
     */
    private String description;
}
