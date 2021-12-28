package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 产品信息Entity
 * @date 2021/12/24 - 15:19
 */
@Setter
@Getter
@ToString
public class ProductInfoEntity {
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品一级
     */
    private ProductInfoEntity ProductLv1;
    /**
     * 产品
     */
    private ProductInfoEntity ProductLv2;
    /**
     * 原料
     */
    private String Ingredient;
    /**
     * 功能简要
     */
    private String description;
    /**
     * 产品图片
     */
    private MultimediaEntity multimedia;

}
