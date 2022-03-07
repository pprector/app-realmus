package com.realmus.common.error;

import lombok.Getter;

/**
 * @author hkpeng
 * @date 2021/12/17 - 10:15
 */

@Getter
public enum BizErrorEnum {

    /**
     * 服务器出错了!
     */
    E001("001", "服务器出错了!"),
    /**
     * 输入语言不存在
     */
    A001("002", "当前语言类别还未加入!"),

    /**
     * 输入语言不存在
     */
    A003("003", "该类型还未加入!"),

    /**
     * 输入语言不存在
     */
    A004("004", "当前Id 信息不存在!"),

    /**
     * 输入语言不存在
     */
    A005("005", "Request 中 不存在语音标识!"),


    /**
     * 输入语言不存在
     */
    B002("006", "没有查询到产品信息!");


    private String code;

    private String message;


    BizErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
