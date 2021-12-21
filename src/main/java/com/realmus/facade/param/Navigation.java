package com.realmus.facade.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author hkpeng
 * 导航栏 数据
 * @date 2021/12/21 - 10:17
 */

@Setter
@Getter
@ToString
public class Navigation implements Serializable {

    private static final long serialVersionId = 1L;
    /**
     * 导航栏ID
     */
    private String navigationId;
    /**
     * 导航栏名称
     */
    private String navigationName;
    /**
     * 跳转地址
     */
    private String h5Url;
    /**
     * 导航层级
     */
    private Integer navigationTier;
}
