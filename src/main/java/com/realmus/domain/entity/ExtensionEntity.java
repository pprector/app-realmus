package com.realmus.domain.entity;

import com.realmus.common.enums.ExtendTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 扩展信息实体类
 * @date 2021/12/27 - 17:45
 */
@Setter
@Getter
@ToString
public class ExtensionEntity<E> {

    private ExtendTypeEnum extendType;

    private String extendId;

    private E extension;

}
