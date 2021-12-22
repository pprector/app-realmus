package com.realmus.domain.entity;

import com.realmus.common.enums.ModuleEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.swing.*;

/**
 * @author hkpeng
 * 轮播返回对象
 * @date 2021/12/22 - 11:54
 */

@Setter
@Getter
@ToString
public class BannerEntity {
    /**
     * 信息Id
     */
    private String infoId;

    /**
     * 模块 枚举
     */
    private ModuleEnum infoType;

    /**
     * 信息 H5链接
     */
    private String h5Url;
    /**
     * 图片获取地址
     */
    private MultimediaEntity multimedia;
    /**
     * 标题
     */
    private String infoTitle;

    /**
     * 描述
     */
    private String infoDescription;

    /**
     * 内容
     */
    private String infoContent;


}
