package com.realmus.facade.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 视频数据
 * @date 2021/12/30 - 14:41
 */
@Setter
@Getter
@ToString
public class Video {
    /**
     * 视频封面URl
     */
    @ApiModelProperty(example = "视频封面URl")
    private Img videoImg;
    /**
     * 媒体获取地址
     */
    @ApiModelProperty(example = "媒体获取地址")
    private String videoUrl;
}
