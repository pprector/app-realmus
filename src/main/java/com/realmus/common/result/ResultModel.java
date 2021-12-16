package com.realmus.common.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hkpeng
 * @date 2021/12/16 - 17:40
 */
@ToString
@Getter
@Setter
public class ResultModel<T> {
    /**
     * 成功状态
     */
    private Integer status;
    /**
     * 当前页
     */
    private Integer pageIndex;
    /**
     * 总记录
     */
    private Integer totalCount;
    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 数据
     */
    private T data;
    /**
     * 错误信息
     */
    private Message message;

}
