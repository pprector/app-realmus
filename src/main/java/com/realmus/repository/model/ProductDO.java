package com.realmus.repository.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* @author hkpeng
* @date 2021/12/30 - 17:23
*/
    
    
@ApiModel(value="com-realmus-repository-model-ProductDO")
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
    * 产品名称
    */
    @ApiModelProperty(value="产品名称")
    private String productName;

    /**
    * 父Id, 如果无为0
    */
    @ApiModelProperty(value="父Id, 如果无为0")
    private String parentId;

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
    * 产品媒体扩展信息
    */
    @ApiModelProperty(value="产品媒体扩展信息")
    private String extendJson;

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