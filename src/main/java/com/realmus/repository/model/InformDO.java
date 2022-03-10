package com.realmus.repository.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* @author hkpeng
* @date 2022/3/9 - 15:08
*/
    
    
@Getter
@Setter
@ToString
public class InformDO {
    /**
    * 通知ID
    */
    private String informId;

    /**
    * 名称
    */
    private String name;

    /**
    * 企业名称
    */
    private String companyName;

    /**
    * 邮箱号
    */
    private String emaliCode;

    /**
    * 是否通知
    */
    private Byte isEmali;

    /**
    * 手机号
    */
    private String phoneCode;

    /**
    * 消息体
    */
    private String informMessage;

    /**
    * 跟进人
    */
    private String merchandiser;

    /**
    * 跟进备注
    */
    private String remarks;

    private Integer isValid;

    private String modifier;

    private Date gmtModified;
}