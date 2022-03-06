package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
     * 产品id
     */
    private String productId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 该分类下 实体
     */
    private List<ProductInfoEntity> sonProductInfoList;
    /**
     * 原料
     */
    private String Ingredient;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 产品图片
     */
    private MultimediaEntity multimedia;

}
