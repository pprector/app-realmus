package com.realmus.repository.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* @author hkpeng
* @date 2021/12/21 - 11:25
*/
    
    
@ApiModel(value="com-realmus-repository-model-Home")
@Getter
@Setter
@ToString
public class HomeDO {
    /**
    * Home ID
    */
    @ApiModelProperty(value="Home ID")
    private String infoId;

    /**
    * 模块数据Code
    */
    @ApiModelProperty(value="模块数据Code")
    private Byte infoType;

    /**
    * 媒体关联中间ID
    */
    @ApiModelProperty(value="媒体关联中间ID")
    private String relationId;

    /**
    * 连接地址
    */
    @ApiModelProperty(value="连接地址")
    private String infoUrl;

    /**
    * 文本标题
    */
    @ApiModelProperty(value="文本标题")
    private String infoTitle;

    /**
    * 文本描述
    */
    @ApiModelProperty(value="文本描述")
    private String infoDescription;

    /**
    * 文本内容
    */
    @ApiModelProperty(value="文本内容")
    private String infoContent;

    /**
    * 权重
    */
    @ApiModelProperty(value="权重")
    private Byte infoWeight;

    /**
    * 数据添加时间
    */
    @ApiModelProperty(value="数据添加时间")
    private Date infoTime;

    @ApiModelProperty(value="")
    private Byte isValid;

    @ApiModelProperty(value="")
    private String modifier;

    @ApiModelProperty(value="")
    private Date gmtModified;
}