package com.realmus.domain.entity;

import com.realmus.common.enums.LanguageEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author hkpeng
 * 表单实体类
 * @date 2022/3/9 - 14:44
 */
@Setter
@Getter
@ToString
public class InformEntity {

    /**
     * 姓名
     */
    private String name;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 留言信息
     */
    private String message;
    /**
     * 语言
     */
    private LanguageEnum languageEnum;

    /**
     * 跟进信息
     */
    FollowUpEntity followUpEntity;

    /**
     * 邮箱类型
     */
    private Integer emailType;
}
