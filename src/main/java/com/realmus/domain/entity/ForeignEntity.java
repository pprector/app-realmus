package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/28 - 15:51
 */
@Setter
@Getter
@ToString
public class ForeignEntity {
    /**
     * 轮播 Banner
     */
    private BannerEntity banner;
}
