package com.realmus.service;

import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.common.result.ResultModel;
import com.realmus.common.util.ResultUtil;
import com.realmus.domain.entity.NavigationEntity;
import com.realmus.domain.service.NavigationService;
import com.realmus.facade.NavigationFacade;
import com.realmus.facade.request.User;
import com.realmus.facade.response.PageNavigationResponse;
import com.realmus.service.converter.NavigationConverter;
import com.realmus.service.converter.TestConverter;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hkpeng
 * @date 2021/12/21 - 10:46
 */

@RestController
@RequestMapping("/navigation")
public class NavigationFacadeImpl implements NavigationFacade {
    private static final Logger logger = LoggerFactory.getLogger(TestFacadeImpl.class);
    private static final TestConverter mapper = Mappers.getMapper(TestConverter.class);


    @Autowired
    private NavigationService navigationService;

    @Override
    @GetMapping("/")
    public ResultModel<List<PageNavigationResponse>> getNavigationInfo() {
        logger.info("=====NavigationFacadeImpl getNavigationInfo request : ");
        try {
            List<NavigationEntity> navigationInfo = navigationService.getNavigationInfo();
            List<PageNavigationResponse> pageNavigationResponses = navigationInfo.stream()
                    .map(NavigationConverter::toPageNavigationResponseList)
                    .collect(Collectors.toList());
            return ResultUtil.success(pageNavigationResponses);
        } catch (BizException e) {
            logger.error("BizException  NavigationFacadeImpl getNavigationInfo request :}" + e);
            return ResultUtil.fail(e.getMessage());
        } catch (Exception e) {
            logger.error("Exception  NavigationFacadeImpl  getNavigationInfo : " + e);
            return ResultUtil.fail(BizErrorEnum.E001.getMessage());
        }
    }
}
