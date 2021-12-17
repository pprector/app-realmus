package com.realmus.common.error;

import lombok.Getter;

/**
 * @author hkpeng
 * @date 2021/12/17 - 10:15
 */

@Getter
public enum BizErrorEnum {
    /**
     * 业务 001
     */
    A001("001", "入参不对哎!");


    private String code;

    private String message;


    BizErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
