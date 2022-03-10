package com.realmus.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * 留言人跟进信息
 * @date 2022/3/9 - 14:52
 */
@Setter
@Getter
@ToString
public class FollowUpEntity {
    /**
     * 是否邮箱通知
     */
    private int isEmali;

    /**
     * 跟进人
     */
    private String merchandiser;

    /**
     * 跟备注
     */
    private String remarks;

}
