package com.realmus.domain.entity;

import com.realmus.facade.param.Video;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class VideoModelEntity {
    @ApiModelProperty(example = "视频标题")
    private String title;
    @ApiModelProperty(example = "视频集合")
    List<VideoEntity> videoList;

}
