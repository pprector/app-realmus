package com.realmus.facade;

import com.realmus.common.result.ResultModel;

import java.io.File;

/**
 * @author hkpeng
 * @date 2021/12/24 - 15:13
 */

public interface ProductFacade {

    /**
     * 产品信息EXCEL 数据导入
     *
     * @param file
     * @return
     */
    ResultModel<Object> productInfoImpl(Integer type, File file);
}
