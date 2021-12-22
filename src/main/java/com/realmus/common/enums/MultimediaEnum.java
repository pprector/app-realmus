package com.realmus.common.enums;

import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import lombok.Getter;

/**
 * @author hkpeng
 * @date 2021/12/22 - 15:41
 */
@Getter
public enum MultimediaEnum {
    IMG(1, "图片"),

    VIDEO(2, "视频");


    private Integer code;

    private String value;


    MultimediaEnum(Integer i, String 轮播图) {

    }

    public static MultimediaEnum getMultimediaEnum(Integer code) {
        if (code == null) {
            return null;
        }
        for (MultimediaEnum typeEnum : MultimediaEnum.values()) {
            if (typeEnum.code.equals(code)) {
                return typeEnum;
            }
        }
        throw new BizException(BizErrorEnum.A003);
    }
}
