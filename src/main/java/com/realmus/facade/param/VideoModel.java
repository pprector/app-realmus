package com.realmus.facade.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hkpeng
 * 视频数据
 * @date 2021/12/30 - 14:41
 */
@Setter
@Getter
@ToString
public class VideoModel {

    @ApiModelProperty(example = "视频标题")
    private String title;
    @ApiModelProperty(example = "视频集合")
    List<Video> videoList;
}
