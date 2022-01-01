package com.realmus.facade;

import com.realmus.common.result.ResultModel;
import com.realmus.facade.request.NavExtendRequest;
import com.realmus.facade.response.NavigationExtendResponse;
import com.realmus.facade.response.NavigationResponse;


import javax.servlet.http.HttpServletRequest;
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
    ResultModel<List<NavigationResponse>> getNavigationInfo(HttpServletRequest request);

    /**
     * 根据 一级导航栏Id 填充 扩展信息
     * @param request
     * @return
     */
    ResultModel<NavigationExtendResponse> getNavigationExtendInfo(NavExtendRequest request, HttpServletRequest httpServletRequest);



   /* *//**
     * 获取 Home 信息
     *
     * @param type
     * @return
     *//*
    ResultModel<HomeResponse> getHomeInfo(Integer type);

    *//**
     * 获取 关于我们  信息
     *
     * @param type
     * @return
     *//*
    ResultModel<AboutUsResponse> getAboutUsInfo(Integer type);
    *//**
     * 获取 智造研发  信息
     *
     * @param type
     * @return
     *//*
    ResultModel<RDResponse> getRDInfo(Integer type);*/
}
