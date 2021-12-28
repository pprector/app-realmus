package com.realmus.domain.entity;

import com.realmus.common.enums.ModuleEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/23 - 11:43
 */
@Setter
@Getter
@ToString
public class CompanyEntity extends PublicInfoEntity {

    /**
     * 背景图
     */
    private MultimediaEntity backgroundImg;

    /**
     * 视频
     */
    private MultimediaEntity promotionalMp4;

    /**
     * 视频背景图
     */
    private MultimediaEntity videoBackgroundImg;

}
