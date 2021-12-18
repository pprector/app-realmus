package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author hkpeng
 * @date 2021/12/18 - 14:45
 */
@Getter
@Setter
public class UserEntity {

    /**
     * Id
     */
    private long userId;
    /**
     * 名称
     */
    private String userName;
    /**
     * 年龄
     */
    private int age;
}
