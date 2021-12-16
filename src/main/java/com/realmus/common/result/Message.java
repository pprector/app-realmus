package com.realmus.common.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/16 - 18:16
 */
@Getter
@Setter
@ToString
public class Message {
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误描述
     */
    private String message;


    public Message(String message) {
        this.message = message;
    }


    public Message(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
