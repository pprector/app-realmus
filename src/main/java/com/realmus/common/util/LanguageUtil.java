package com.realmus.common.util;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * realmus.com
 *
 * @Author hkpeng
 * @Description TODO
 * @Date 2022/1/1 17:27
 * @Version 1.0
 */
public class LanguageUtil {
    private  static final  String  LANGUAGE = "language";

    /**
     * 根据请求头数据获取  语言枚举
     * @param request
     * @return
     */
    public static LanguageEnum getLanguageEnum(HttpServletRequest request){
        String language = request.getParameter(LANGUAGE);
        ValidationUtil.checkout(language, BizErrorEnum.A005);
        return LanguageEnum.getLanguageEnum(language);
    }
}
