package com.realmus.service;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.common.result.ResultModel;
import com.realmus.common.util.LanguageUtil;
import com.realmus.common.util.ResultUtil;
import com.realmus.common.util.ValidationUtil;

import com.realmus.domain.entity.NavigationEntity;
import com.realmus.domain.service.NavigationService;
import com.realmus.facade.NavigationFacade;
import com.realmus.facade.request.NavExtendRequest;
import com.realmus.facade.response.NavigationExtendResponse;
import com.realmus.facade.response.NavigationResponse;

import com.realmus.service.converter.InfoConverter;
import com.realmus.service.converter.NavigationConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hkpeng
 * @date 2021/12/21 - 10:46
 */

@RestController
@RequestMapping("/navigation")
@Api(tags = "导航栏操作接口组,主数据获取接口")
public class NavigationFacadeImpl implements NavigationFacade {
    private static final Logger logger = LoggerFactory.getLogger(NavigationFacadeImpl.class);


    @Autowired
    private NavigationService navigationService;


    @ApiOperation(value = "导航栏全量数据获取", httpMethod = "GET")
    @Override
    @GetMapping(value = "/",params = {"language"})
    public ResultModel<List<NavigationResponse>> getNavigationInfo(HttpServletRequest httpServletRequest) {
        logger.info("=====NavigationFacadeImpl getNavigationInfo request : ");
        try {
            LanguageEnum languageEnum = LanguageUtil.getLanguageEnum(httpServletRequest);
            List<NavigationEntity> navigationInfo = navigationService.getNavigationInfo(languageEnum);
            List<NavigationResponse> pageNavigationResponses = navigationInfo.stream()
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

    @Override
    @ApiOperation(value = "导航栏扩展信息数据根据 一级导航栏Id 获取", httpMethod = "POST")
    @PostMapping(value = "/extend",params = {"language"})
    public ResultModel<NavigationExtendResponse> getNavigationExtendInfo(@ApiParam(name="传入对象",value="传入json格式",required=true)
                                                                             @RequestBody NavExtendRequest request, HttpServletRequest httpServletRequest) {
        logger.info("=====NavigationFacadeImpl getHomeInfo request : ");
        try {
            ValidationUtil.validate(request);
            LanguageEnum languageEnum = LanguageUtil.getLanguageEnum(httpServletRequest);
            NavigationEntity navigationExtendInfo = navigationService.getNavigationExtendInfo(languageEnum, request.getNavId());
            NavigationExtendResponse navigationExtendResponse = InfoConverter.NavigationExtendResponse(navigationExtendInfo);
            return ResultUtil.success(navigationExtendResponse);
        } catch (BizException e) {
            logger.error("=====BizException  NavigationFacadeImpl getNavigationExtendInfo request :"+request, e);
            return ResultUtil.fail(e.getMessage());
        } catch (Exception e) {
            logger.error("=====Exception  NavigationFacadeImpl  getNavigationInfo request : "+request, e);
            return ResultUtil.fail(BizErrorEnum.E001.getMessage());
        }
    }
}
