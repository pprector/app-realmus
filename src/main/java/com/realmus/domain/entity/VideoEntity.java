package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/29 - 15:27
 */
@Setter
@Getter
@ToString
public class VideoEntity extends MultimediaEntity {
    /**
     * 视频封面URl
     */
    private String coverImgUrl;
}
