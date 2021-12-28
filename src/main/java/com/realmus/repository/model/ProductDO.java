package com.realmus.repository.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* @author hkpeng
* @date 2021/12/21 - 11:27
*/
    
    
@ApiModel(value="com-realmus-repository-model-CnProduct")
@Getter
@Setter
@ToString
public class ProductDO {
    /**
    * 产品主键
    */
    @ApiModelProperty(value="产品主键")
    private String productId;

    /**
    * 产品类型一级类型Name
    */
    @ApiModelProperty(value="产品类型一级类型Name")
    private String productLv1type;

    /**
    * 1媒体ID
    */
    @ApiModelProperty(value="1媒体ID")
    private String productLv1RelationId;

    /**
    * 产品类型二级级类型Name
    */
    @ApiModelProperty(value="产品类型二级级类型Name")
    private String productLv2type;


    /**
    * 产品名称
    */
    @ApiModelProperty(value="产品名称")
    private String productName;

    /**
    * 产品成分
    */
    @ApiModelProperty(value="产品成分")
    private String productIngredient;

    /**
    * 产品描述
    */
    @ApiModelProperty(value="产品描述")
    private String productDescribe;

    /**
    * 产品权重
    */
    @ApiModelProperty(value="产品权重")
    private Integer productWeight;

    /**
    * 3媒体ID
    */
    @ApiModelProperty(value="3媒体ID")
    private String productRelationId;

    /**
    *  有效标识 0失效 1生效
    */
    @ApiModelProperty(value=" 有效标识 0失效 1生效")
    private Integer isValid;

    @ApiModelProperty(value="")
    private String modifier;

    @ApiModelProperty(value="")
    private Date gmtModified;
}