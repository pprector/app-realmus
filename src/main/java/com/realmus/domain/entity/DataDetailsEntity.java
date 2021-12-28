package com.realmus.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/28 - 17:48
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class DataDetailsEntity {
    /**
     * 数值
     */
    private String number;
    /**
     * 计量单位
     */
    private String units;
    /**
     * 数据 描述
     */
    private String desc;


}
