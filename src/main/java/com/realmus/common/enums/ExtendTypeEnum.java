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

    ABOUT_US("1640068311", "关于我们", "AboutUsEntity"),

    NEWS("1640068343", "新闻中心", "NewsEntity"),

    PRODUCT("1640068339", "产品中心", "NewsEntity"),

    RD("1640068346", "制造研发(R&D)", "RDEntity"),

    CONTACT_US("1640068351", "联系我们", "ContactUsEntity"),

    FOREIGN("1640068348", "外贸出口", "ForeignEntity"),

    BRAND("1640068328", "品牌中心", "BrandEntity");


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
