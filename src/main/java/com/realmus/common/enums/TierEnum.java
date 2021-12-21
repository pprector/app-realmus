package com.realmus.common.enums;

import lombok.Getter;

/**
 * @author hkpeng
 * @date 2021/12/21 - 13:04
 */
@Getter
public enum TierEnum {
    LV1(1, "层级1"),

    LV2(2, "层级2");

    private Integer code;

    private String value;

    TierEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
