package com.realmus.domain.entity;

import com.realmus.common.enums.MultimediaEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 媒体对象
 * @date 2021/12/22 - 15:38
 */
@Setter
@Getter
@ToString
public class MultimediaEntity {
    /**
     * 关联ID
     */
    private String relationId;
    /**
     * 媒体
     */
    private String multimediaId;
    /**
     * 媒体类型
     */
    private MultimediaEnum multimediaType;
    /**
     * 媒体获取地址
     */
    private String multimediaUrl;
    /**
     * 媒体描述信息
     */
    private String description;

}
