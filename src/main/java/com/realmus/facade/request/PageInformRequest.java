package com.realmus.facade.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/30 - 15:35
 */
@Setter
@Getter
@ToString
public class PageInformRequest extends PagingRequest {

    /**
     * 是否通知
     */
    @ApiModelProperty(value = "邮箱 - 模糊查询")
    private String mali;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号 - 模糊查询")
    private String phoneCode;

}
