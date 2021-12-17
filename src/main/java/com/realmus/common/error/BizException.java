package com.realmus.common.error;

import lombok.Getter;

/**
 * 自定义异常类
 *
 * @author hkpeng
 * @date 2021/12/17 - 10:12
 */

@Getter
public class BizException extends RuntimeException {

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(BizErrorEnum errorEnum) {
        super(errorEnum.getMessage());
    }


}
