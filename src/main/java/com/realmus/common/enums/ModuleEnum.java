package com.realmus.common.enums;

import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import lombok.Getter;

/**
 * @author hkpeng
 * @date 2021/12/22 - 15:10
 */

@Getter
public enum ModuleEnum {

    BANNER(1, "轮播图");


    private Integer code;

    private String value;


    ModuleEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static ModuleEnum getModuleEnum(Integer code) {
        if (code == null) {
            return null;
        }
        for (ModuleEnum typeEnum : ModuleEnum.values()) {
            if (typeEnum.code.equals(code)) {
                return typeEnum;
            }
        }
        throw new BizException(BizErrorEnum.A003);
    }
}
