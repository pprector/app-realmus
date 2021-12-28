package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 新闻中心  实体类
 * @date 2021/12/28 - 14:40
 */
@Setter
@Getter
@ToString
public class NewsEntity {
    /**
     * 轮播 Banner
     */
    private BannerEntity banner;
}
