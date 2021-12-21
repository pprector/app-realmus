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
    
    
@ApiModel(value="com-realmus-repository-model-Inform")
@Getter
@Setter
@ToString
public class InformDO {
    /**
    * 通知ID
    */
    @ApiModelProperty(value="通知ID")
    private String informId;

    /**
    * 邮箱号
    */
    @ApiModelProperty(value="邮箱号")
    private String emaliCode;

    /**
    * 是否通知
    */
    @ApiModelProperty(value="是否通知")
    private Byte isEmali;

    /**
    * 手机号
    */
    @ApiModelProperty(value="手机号")
    private String phoneCode;

    /**
    * 是否通知
    */
    @ApiModelProperty(value="是否通知")
    private Byte isNote;

    /**
    * 消息体
    */
    @ApiModelProperty(value="消息体")
    private String informMessage;

    /**
    * 是否跟进
    */
    @ApiModelProperty(value="是否跟进")
    private Byte isDocumentary;

    /**
    * 跟进人
    */
    @ApiModelProperty(value="跟进人")
    private String merchandiser;

    /**
    * 跟进备注
    */
    @ApiModelProperty(value="跟进备注")
    private String remarks;

    @ApiModelProperty(value="")
    private Byte isValid;

    @ApiModelProperty(value="")
    private String modifier;

    @ApiModelProperty(value="")
    private Date gmtModified;
}