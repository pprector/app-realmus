package com.realmus.domain.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/24 - 15:19
 */
@Setter
@Getter
@ToString
public class ProductEntity {
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品一级
     */
    private ProductEntity ProductLv1;
    /**
     * 产品
     */
    private ProductEntity ProductLv2;
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
