package com.realmus.repository.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* @author hkpeng
* @date 2021/12/21 - 11:26
*/
    
    
@ApiModel(value="com-realmus-repository-model-Multimedia")
@Getter
@Setter
@ToString
public class MultimediaDO {
    /**
    * 媒体ID
    */
    @ApiModelProperty(value="媒体ID")
    private String multimediaId;

    /**
    * 媒体类型1:图片,2.视频
    */
    @ApiModelProperty(value="媒体类型1:图片,2.视频")
    private Integer multimediaType;

    /**
    * 获取连接地址
    */
    @ApiModelProperty(value="获取连接地址")
    private String multimediaUrl;

    /**
    * 媒体描述
    */
    @ApiModelProperty(value="媒体描述")
    private String multimediaDesc;

    /**
    * 有效标识 0失效 1生效
    */
    @ApiModelProperty(value="有效标识 0失效 1生效")
    private Integer isValid;

    /**
    * 修改者
    */
    @ApiModelProperty(value="修改者")
    private String modifier;

    /**
    *  修改时间
    */
    @ApiModelProperty(value=" 修改时间")
    private Date gmtModified;
}