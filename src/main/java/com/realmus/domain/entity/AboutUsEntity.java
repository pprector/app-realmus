package com.realmus.domain.entity;

import com.realmus.facade.param.Banner;
import com.realmus.facade.param.Company;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hkpeng
 * 关于我们   信息
 * @date 2021/12/27 - 15:48
 */
@Setter
@Getter
@ToString
public class AboutUsEntity {
    /**
     * 轮播 Banner
     */
    private BannerEntity banner;

    /**
     * 关于企业 视频 + 图片
     */
    private CompanyEntity company;
    /**
     * 发展历程 轮播图
     */
    private List<BannerEntity> courseBannerList;
    /**
     * 数据展示
     */
    private DataDisplayEntity dataDisplayEntity;
    /**
     * 证书中心 N个图
     */
    private List<MultimediaEntity> imgUrlList;

}
