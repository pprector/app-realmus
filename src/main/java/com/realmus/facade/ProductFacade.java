package com.realmus.facade;

import com.realmus.common.result.ResultModel;
import com.realmus.facade.response.ProductResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

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
    ResultModel<Object> productInfoImpl(String type, File file);


    /**
     * 产品信息 根据一级分类名称获取 产品信息
     *
     * @param
     * @return
     */
    ResultModel<ProductResponse> getProductInfo(String lv1Name, HttpServletRequest httpServletRequest);


    /**
     * 产品信息 根据一级分类名称获取 产品信息
     *
     * @param
     * @return
     */
    ResultModel<List<ProductResponse>> productSearch(String input, HttpServletRequest httpServletRequest);
}
