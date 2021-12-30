package com.realmus.facade.param;

import com.realmus.domain.entity.BannerEntity;
import com.realmus.domain.entity.VideoEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hkpeng
 * 制造研发
 * @date 2021/12/30 - 14:39
 */
@Setter
@Getter
@ToString
public class RDIntelligentPlant {
    /**
     * 主信息banner
     */
    @ApiModelProperty(example = "主信息 工厂详情 banner")
    Banner mainBanner;
    /**
     * 智能工厂详情  banner
     */
    @ApiModelProperty(example = "智能工厂详情 banner")
    Banner factoryBanner;

    /**
     * 工厂视频集合
     */
    @ApiModelProperty(example = "视频集合 ")
    List<Video> videoList;
}
