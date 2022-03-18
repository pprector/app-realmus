package com.realmus.common.enums;

import java.util.Arrays;

/**
 * @author pengzhengjie
 */

public enum EmailEnum {

    /** 普通邮件 */
    ORDINARY_MAIL(1, "普通邮件"),
    /** 附件邮件 */
    ENCLOSURE_MAIL(2, "附件邮件"),
    /** 文本带图片邮件 **/
    ORDINARY_IMAGE_MAIL(3, "文本带图片邮件"),
    ;

    private final Integer type;

    private final String name;

    EmailEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    /**
     * 根据数据类型获取枚举对象
     *
     * @param typeId 数据类型值
     * @return 数据类型枚举
     */
    public static EmailEnum getByType(Integer typeId) {
        //枚举结果
        return Arrays.stream(values()).filter(item -> item.getType().equals(typeId)).findAny()
                .orElseThrow(() -> new IllegalArgumentException("Invalid EmailEnum type: " + typeId));
    }

    @Override
    public String toString() {
        return "EmailEnum{" +
                "type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
