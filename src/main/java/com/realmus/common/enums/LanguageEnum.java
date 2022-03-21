package com.realmus.common.enums;

import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;

/**
 * @author hkpeng
 * @date 2021/12/21 - 15:43
 */

public enum LanguageEnum {

    CHINESE("zh-CN", "中文"),

    ENGLISH("en-US", "英文");

    private String code;

    private String value;

    LanguageEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static LanguageEnum getLanguageEnum(String code) {
        if (code == null) {
            return null;
        }
        for (LanguageEnum typeEnum : LanguageEnum.values()) {
            if (typeEnum.code.equals(code)) {
                return typeEnum;
            }
        }
        throw new BizException(BizErrorEnum.A001);
    }
}
