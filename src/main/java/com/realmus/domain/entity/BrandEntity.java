package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 品牌中心
 * @date 2021/12/28 - 15:50
 */
@Setter
@Getter
@ToString
public class BrandEntity {
    /**
     * 轮播 Banner
     */
    private BannerEntity banner;
}
