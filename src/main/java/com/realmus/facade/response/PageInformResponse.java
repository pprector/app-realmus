package com.realmus.facade.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author hkpeng
 * 获取消息通知 返回体
 * @date 2021/12/30 - 15:19
 */
@Setter
@Getter
@ToString
public class PageInformResponse extends PagingResponse{
    /**
     * 通知ID
     */
    @ApiModelProperty(value="通知ID")
    private String informId;

    /**
     * 邮箱号
     */
    @ApiModelProperty(value="邮箱号")
    private String maliCode;

    /**
     * 是否通知
     */
    @ApiModelProperty(value="是否通知")
    private Integer isMali;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phoneCode;

    /**
     * 是否通知
     */
    @ApiModelProperty(value="是否通知")
    private Integer isNote;

    /**
     * 消息体
     */
    @ApiModelProperty(value="消息体")
    private String informMessage;

    /**
     * 是否跟进
     */
    @ApiModelProperty(value="是否跟进")
    private Integer isDocumentary;
    /**
     * 跟进人
     */
    @ApiModelProperty(value="跟进人")
    private String merchandiser;
    /**
     * 跟进备注
     */
    @ApiModelProperty(value="跟进备注")
    private String remarks;
}
