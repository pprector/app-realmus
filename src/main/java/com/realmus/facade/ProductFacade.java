package com.realmus.facade;

import com.realmus.common.result.ResultModel;
import com.realmus.facade.request.SearchRequest;
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
     * 产品信息查询
     * 参数为空返回全量数据
     * 参数不为空模糊查询
     *
     * @param
     * @return
     */
    ResultModel<List<ProductResponse>> productSearch(SearchRequest input, HttpServletRequest httpServletRequest);
}
