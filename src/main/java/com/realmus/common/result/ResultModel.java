package com.realmus.common.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/16 - 17:40
 */
@ToString
@Getter
@Setter
public class ResultModel<T> {
    /**
     * 成功状态
     */
    private Integer status;
    /**
     * 数据
     */
    private T result;
    /**
     * 错误信息
     */
    private String message;

}
