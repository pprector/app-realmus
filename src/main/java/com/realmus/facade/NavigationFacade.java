package com.realmus.facade;

import com.realmus.common.result.ResultModel;
import com.realmus.facade.response.PageNavigationResponse;

import java.util.List;

/**
 * realmus.com
 *
 * @Author hkpeng
 * @Description 网站标题栏请求接口
 * @Date 2021/12/20 22:23
 * @Version 1.0
 */
public interface NavigationFacade {

    /**
     * 获取导航栏数据
     *
     * @return
     */
    ResultModel<List<PageNavigationResponse>> getNavigationInfo(Integer type);
}
