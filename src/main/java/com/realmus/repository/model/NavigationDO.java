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


@ApiModel(value = "com-realmus-repository-model-CnNavigation")
@Getter
@Setter
@ToString
public class NavigationDO {
    /**
     * 导航栏ID
     */
    private String navigationId;

    /**
     * 导航栏名称
     */
    private String navigationName;

    /**
     * 导航栏连接地址
     */
    private String navigationUrl;
    /**
     * 扩展信息JSON
     */
    private String extendJson;

    /**
     * 导航栏层级
     */
    private Integer navigationTier;

    /**
     * 导航父级ID
     */
    private String navigationParentId;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 有效标识 0失效 1生效
     */
    private Integer isValid;

    /**
     * 修改者
     */
    private String modifier;

    /**
     * 修改时间
     */
    private Date gmtModified;
}