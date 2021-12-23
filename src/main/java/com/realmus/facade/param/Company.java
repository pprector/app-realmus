package com.realmus.facade.param;

import com.realmus.domain.entity.MultimediaEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/23 - 15:17
 */
@Setter
@Getter
@ToString
public class Company extends PublicInfo {
    /**
     * 背景图
     */
    private String backgroundImg;

    /**
     * 背景图
     */
    private String promotionalMp4;


    /**
     * 背景图
     */
    private String videoBackgroundImg;
}
