package com.realmus.domain.entity;

import com.realmus.facade.param.Navigation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author hkpeng
 * 导航栏实体
 * @date 2021/12/21 - 10:53
 */

@ToString
@Getter
@Setter
public class NavigationEntity<T> {
    /**
     * 导航栏ID
     */
    private String navigationId;
    /**
     * 导航栏名称
     */
    private String navigationName;
    /**
     * 父级ID
     */
    private String navigationParentId;
    /**
     * 跳转地址
     */
    private String h5Url;
    /**
     * 导航层级
     */
    private Integer navigationTier;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 子导航栏
     */
    List<NavigationEntity> sonNavigationList;
    /**
     * 扩展信息JSON
     */
    private T extension;
}
