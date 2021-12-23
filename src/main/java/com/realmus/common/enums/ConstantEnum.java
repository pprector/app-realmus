package com.realmus.common.enums;

import lombok.Getter;

/**
 * @author hkpeng
 * @date 2021/12/23 - 14:34
 */
@Getter
public enum ConstantEnum {
    CONSTANT_1("模块2背景图"),

    CONSTANT_2("模块2视频"),

    CONSTANT_3("模块2视频封面"),


    ;


    private String desc;

    ConstantEnum(String desc) {
        this.desc = desc;
    }
}
