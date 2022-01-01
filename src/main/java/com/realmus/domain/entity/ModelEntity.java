package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * realmus.com
 *
 * @Author hkpeng
 * @Description TODO
 * @Date 2022/1/1 21:18
 * @Version 1.0
 */
@Setter
@Getter
@ToString
public class ModelEntity<T> {
    /**
     * 模块Id
     */
    private String modelId;
    /**
     * 模块数据s
     */
    private T data;
}
