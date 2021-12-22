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


@Getter
@Setter
@ToString
public class HomeDO {
    /**
     * Home ID
     */
    private String infoId;

    /**
     * 模块数据Code
     */
    private Integer infoType;

    /**
     * 媒体关联中间ID
     */
    private String relationId;

    /**
     * 连接地址
     */
    private String infoUrl;

    /**
     * 文本标题
     */

    private String infoTitle;

    /**
     * 文本描述
     */
    private String infoDescription;

    /**
     * 文本内容
     */

    private String infoContent;

    /**
     * 权重
     */
    private Integer infoWeight;

    /**
     * 数据添加时间
     */
    private Date infoTime;


    private Integer isValid;


    private String modifier;

    private Date gmtModified;
}