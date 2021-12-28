package com.realmus.domain.entity;

import com.realmus.common.enums.ModuleEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * Home 公共信息
 * @date 2021/12/23 - 11:46
 */
@Setter
@Getter
@ToString
public class PublicInfoEntity {


    /**
     * 模块 枚举
     */
    private ModuleEnum infoType;

    /**
     * 信息 H5链接
     */
    private String h5Url;
    /**
     * 标题
     */
    private String infoTitle;

    /**
     * 描述
     */
    private String infoDescription;

    /**
     * 内容
     */
    private String infoContent;

}
