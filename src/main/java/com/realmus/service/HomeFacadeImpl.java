package com.realmus.service;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.common.result.ResultModel;
import com.realmus.common.util.ResultUtil;
import com.realmus.domain.entity.HomeInfoEntity;
import com.realmus.domain.service.HomeService;
import com.realmus.facade.HomeFacade;
import com.realmus.facade.response.QueryHomeResponse;
import com.realmus.service.converter.HomeInfoConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hkpeng
 * @date 2021/12/22 - 14:13
 */
@RestController
@RequestMapping(value = "/home")
@Api(tags = "Home 模块操作接口")
public class HomeFacadeImpl implements HomeFacade {
    private static final Logger logger = LoggerFactory.getLogger(HomeFacadeImpl.class);

    @Autowired
    private HomeService homeService;


    @ApiOperation(value = "Home 全量信息获取", httpMethod = "GET")
    @ApiImplicitParam(name = "type", value = "语言类型", required = true, dataType = "int")
    @Override
    @GetMapping("/{type}")
    public ResultModel<QueryHomeResponse> getHomeInfo(@PathVariable Integer type) {
        logger.info("=====HomeFacadeImpl getHomeInfo request : ");
        try {
            HomeInfoEntity homeInfoEntity = homeService.getHomeInfo(LanguageEnum.getLanguageEnum(type));
            QueryHomeResponse homeResponse = HomeInfoConverter.toQueryHomeResponse(homeInfoEntity);
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
