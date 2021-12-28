package com.realmus.common.enums;

import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import lombok.Getter;

/**
 * @author hkpeng
 * @date 2021/12/27 - 17:32
 */
@Getter
public enum ExtendTypeEnum {

    HOME_INFO("1640068138", "Home首页", "HomeInfoEntity"),

    ABOUT_US("1640068311", "关于我们", "AboutUsEntity");


    private String id;

    private String value;

    private String desc;

    ExtendTypeEnum(String id, String value, String desc) {
        this.id = id;
        this.value = value;
        this.desc = desc;
    }

    public static ExtendTypeEnum getLanguageEnum(String id) {
        if (id == null) {
            return null;
        }
        for (ExtendTypeEnum typeEnum : ExtendTypeEnum.values()) {
            if (typeEnum.id.equals(id)) {
                return typeEnum;
            }
        }
        throw new BizException(BizErrorEnum.A004);
    }
}
