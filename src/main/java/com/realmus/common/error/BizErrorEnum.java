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
    A001("002", "当前语言类别还未加入!");


    private String code;

    private String message;


    BizErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
