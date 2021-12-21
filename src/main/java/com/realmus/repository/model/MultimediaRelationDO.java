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
    
    
@ApiModel(value="com-realmus-repository-model-CnMultimediaRelation")
@Getter
@Setter
@ToString
public class MultimediaRelationDO {
    /**
    * 关联主键
    */
    @ApiModelProperty(value="关联主键")
    private String relationId;

    /**
    * 媒体ID
    */
    @ApiModelProperty(value="媒体ID")
    private String multimediaId;

    @ApiModelProperty(value="")
    private Byte isValid;

    @ApiModelProperty(value="")
    private String modifier;

    @ApiModelProperty(value="")
    private Date gmtModified;
}