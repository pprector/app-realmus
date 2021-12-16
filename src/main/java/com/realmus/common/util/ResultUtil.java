package com.realmus.common.util;

import com.realmus.common.enums.GeneralEnum;
import com.realmus.common.result.Message;
import com.realmus.common.result.ResultModel;

/**
 * 返回数据工具类
 *
 * @author hkpeng
 * @date 2021/12/16 - 17:47
 */

public class ResultUtil {
    /**
     * 返回成功结果
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultModel<T> success(T data) {
        ResultModel result = new ResultModel();
        result.setStatus(GeneralEnum.YES.getCode());
        result.setData(data);
        return result;
    }

    /**
     * 返回失败结果
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultModel<T> fail(String message) {
        ResultModel result = new ResultModel();
        result.setStatus(GeneralEnum.NO.getCode());
        result.setMessage(new Message(message));

        return result;
    }

}
