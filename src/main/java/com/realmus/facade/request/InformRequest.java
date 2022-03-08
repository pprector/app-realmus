package com.realmus.facade.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author hkpeng
 * @date 2022/3/8 - 16:52
 */
@Setter
@Getter
@ToString
@ApiModel(value = "表单提交类", description = "客人留言信息保存数据库")
public class InformRequest {


    @ApiModelProperty(example = "姓名")
    @NotNull(message = "姓名 不可为空")
    private String name;

    @ApiModelProperty(example = "企业名称")
    private String companyName;

    @ApiModelProperty(example = "邮箱号")
    @NotNull(message = "邮箱号 不可为空")
    private String email;

    @ApiModelProperty(example = "手机号")
    private String phone;

    @ApiModelProperty(example = "留言信息")
    private String message;

}
