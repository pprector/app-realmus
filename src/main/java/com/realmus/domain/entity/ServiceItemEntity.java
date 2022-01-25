package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author hkpeng
 * 服务项目
 * @date 2021/12/27 - 17:09
 */
@ToString
@Getter
@Setter
public class ServiceItemEntity {
    /**
     * 标题
     */
    private String headLine;
    /**
     * 描述
     */
    private String desc;
    /**
     * 媒体信息
     */
    private MultimediaEntity multimediaEntity;
    /**
     * 服务项目 Banner
     * 六个描述信息
     */
    private List<PublicInfoEntity> ItemInfoList;
}
