package com.realmus.service;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.common.result.ResultModel;
import com.realmus.common.util.ResultUtil;
import com.realmus.domain.entity.AboutUsEntity;
import com.realmus.domain.entity.HomeInfoEntity;
import com.realmus.domain.entity.NavigationEntity;
import com.realmus.domain.service.NavigationService;
import com.realmus.facade.NavigationFacade;
import com.realmus.facade.response.AboutUsResponse;
import com.realmus.facade.response.PageNavigationResponse;
import com.realmus.facade.response.QueryHomeResponse;
import com.realmus.service.converter.InfoConverter;
import com.realmus.service.converter.NavigationConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hkpeng
 * @date 2021/12/21 - 10:46
 */

@RestController
@Api(tags = "导航栏操作接口组,主数据获取接口")
public class NavigationFacadeImpl implements NavigationFacade {
    private static final Logger logger = LoggerFactory.getLogger(NavigationFacadeImpl.class);


    @Autowired
    private NavigationService navigationService;


    @ApiOperation(value = "导航栏全量数据获取", httpMethod = "GET")
    @ApiImplicitParam(name = "type", value = "语言类型", required = true, dataType = "int")
    @Override
    @GetMapping("/navigation/{type}")
    public ResultModel<List<PageNavigationResponse>> getNavigationInfo(@PathVariable("type") Integer type) {
        logger.info("=====NavigationFacadeImpl getNavigationInfo request : ");
        try {
            List<NavigationEntity> navigationInfo = navigationService.getNavigationInfo(LanguageEnum.getLanguageEnum(type));
            List<PageNavigationResponse> pageNavigationResponses = navigationInfo.stream()
                    .map(NavigationConverter::toPageNavigationResponseList)
                    .collect(Collectors.toList());
            return ResultUtil.success(pageNavigationResponses);
        } catch (BizException e) {
            logger.error("=====BizException  NavigationFacadeImpl getNavigationInfo request :}", e);
            return ResultUtil.fail(e.getMessage());
        } catch (Exception e) {
            logger.error("=====Exception  NavigationFacadeImpl  getNavigationInfo : ", e);
            return ResultUtil.fail(BizErrorEnum.E001.getMessage());
        }
    }

    @ApiOperation(value = "Home 全量信息获取", httpMethod = "GET")
    @ApiImplicitParam(name = "type", value = "语言类型", required = true, dataType = "int")
    @Override
    @GetMapping("/home/{type}")
    public ResultModel<QueryHomeResponse> getHomeInfo(@PathVariable Integer type) {
        logger.info("=====NavigationFacadeImpl getHomeInfo request : ");
        try {
            HomeInfoEntity homeInfoEntity = navigationService.getHomeInfo(LanguageEnum.getLanguageEnum(type));
            QueryHomeResponse homeResponse = InfoConverter.toQueryHomeResponse(homeInfoEntity);
            return ResultUtil.success(homeResponse);
        } catch (BizException e) {
            logger.error("=====BizException  NavigationFacadeImpl getNavigationInfo request :}", e);
            return ResultUtil.fail(e.getMessage());
        } catch (Exception e) {
            logger.error("=====Exception  NavigationFacadeImpl  getNavigationInfo : ", e);
            return ResultUtil.fail(BizErrorEnum.E001.getMessage());
        }
    }


    @ApiOperation(value = "关于我们模块 全量信息获取", httpMethod = "GET")
    @ApiImplicitParam(name = "type", value = "语言类型", required = true, dataType = "int")
    @Override
    @GetMapping("/aboutus/{type}")
    public ResultModel<AboutUsResponse> getAboutUsInfo(@PathVariable Integer type) {
        logger.info("=====NavigationFacadeImpl getAboutUsInfo request : ");
        try {
            AboutUsEntity aboutUsEntity = navigationService.getAboutUsInfo(LanguageEnum.getLanguageEnum(type));
            AboutUsResponse homeResponse = InfoConverter.toAboutUsResponse(aboutUsEntity);
            return ResultUtil.success(homeResponse);
        } catch (BizException e) {
            logger.error("=====BizException  NavigationFacadeImpl getNavigationInfo request :}", e);
            return ResultUtil.fail(e.getMessage());
        } catch (Exception e) {
            logger.error("=====Exception  NavigationFacadeImpl  getNavigationInfo : ", e);
            return ResultUtil.fail(BizErrorEnum.E001.getMessage());
        }
    }
}
