package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 制造研发 之 研发创新信息
 * @date 2021/12/29 - 10:50
 */
@ToString
@Getter
@Setter
public class RDIInfoEntity {
    /**
     * 主 bannner
     */
    private BannerEntity mainBanner;

    /**
     * 研发标题
     */
    private String headLine;
    /**
     * 研发描述
     */
    private String description;
    /**
     * banner
     */
    private BannerEntity databaseBanner;
    /**
     * banner
     */
    private BannerEntity teamBanner;
    /**
     * banner
     */
    private BannerEntity patentBanner;

}
