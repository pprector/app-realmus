package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * @author hkpeng
 * RD 之 智能工厂信息
 * @date 2021/12/29 - 10:38
 */
@ToString
@Getter
@Setter
public class RDIntelligentPlantEntity {
    /**
     * 主信息banner
     */
    BannerEntity mainBanner;
    /**
     * 智能工厂详情  banner
     */
    BannerEntity factoryBanner;

    /**
     * 工厂视频集合
     */
    List<MultimediaEntity> videoList;
}
