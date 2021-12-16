package com.realmus.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hkpeng
 * @date 2021/12/16 - 17:53
 */
@Getter
public enum GeneralEnum {
    YES(1, "是"),

    NO(0, "否");

    private Integer code;

    private String value;

    GeneralEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
