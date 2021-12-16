package com.realmus.facade.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author hkpeng
 * @date 2021/12/16 - 17:35
 */

@Getter
@Setter
@ToString
public class User implements Serializable {
    /**
     * Id
     */
    private long userId;
    /**
     * 名称
     */
    @NotNull(message = "用户名不能为空")
    private String userName;
    /**
     * 年龄
     */
    @Min(value = 1,message = "年龄不能低于1岁哦!")
    private int age;
}
