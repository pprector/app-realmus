package com.realmus.service;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.common.result.ResultModel;
import com.realmus.common.util.ResultUtil;
import com.realmus.domain.entity.NavigationEntity;
import com.realmus.domain.service.NavigationService;
import com.realmus.facade.NavigationFacade;
import com.realmus.facade.response.PageNavigationResponse;
import com.realmus.service.converter.NavigationConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.mapstruct.factory.Mappers;
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
@RequestMapping(value = "/navigation")
@Api(tags = "导航栏操作接口组")
public class NavigationFacadeImpl implements NavigationFacade {
    private static final Logger logger = LoggerFactory.getLogger(NavigationFacadeImpl.class);


    @Autowired
    private NavigationService navigationService;


    @ApiOperation(value = "导航栏全量数据获取", httpMethod = "GET")
    @ApiImplicitParam(name = "type", value = "语言类型", required = true, dataType = "int")
    @Override
    @GetMapping("/{type}")
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
}
