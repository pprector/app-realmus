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
public class BannerEntity extends PublicInfoEntity {

    /**
     * 图片获取地址
     */
    private MultimediaEntity bannerImg;

}
