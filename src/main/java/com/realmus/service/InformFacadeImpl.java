package com.realmus.service;

import com.realmus.common.enums.LanguageEnum;
import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.common.result.ResultModel;
import com.realmus.common.util.LanguageUtil;
import com.realmus.common.util.ResultUtil;
import com.realmus.common.util.ValidationUtil;
import com.realmus.domain.entity.FollowUpEntity;
import com.realmus.domain.entity.InformEntity;
import com.realmus.domain.entity.NavigationEntity;
import com.realmus.domain.service.InformService;
import com.realmus.facade.InformFacade;
import com.realmus.facade.request.InformRequest;
import com.realmus.facade.request.PageInformRequest;
import com.realmus.facade.response.NavigationExtendResponse;
import com.realmus.facade.response.PageInformResponse;
import com.realmus.service.converter.InfoConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hkpeng
 * @date 2021/12/30 - 15:41
 */
@RestController
@RequestMapping("/inform")
@Api(tags = "导航栏操作接口组,主数据获取接口")
public class InformFacadeImpl implements InformFacade {
    private static final Logger logger = LoggerFactory.getLogger(InformFacadeImpl.class);


    @Autowired
    private InformService informService;

    @Override
    public ResultModel<PageInformResponse> pageInform(PageInformRequest request) {
        return null;
    }


    /**
     * 表单信息提交
     * 邮箱通知本企业,
     * 邮箱通知客户
     *
     * @param httpServletRequest
     * @param request
     * @return
     */
    @ApiOperation(value = "导航栏扩展信息数据根据 一级导航栏Id 获取", httpMethod = "POST")
    @PostMapping(value = "/add", params = {"language"})
    @Override
    public ResultModel<Void> addInform(HttpServletRequest httpServletRequest, @ApiParam(name = "表单提交对象", value = "传入json格式", required = true)
            InformRequest request) {
        logger.info("=====InformFacadeImpl addInform request : " + request);
        try {
            ValidationUtil.validate(request);
            LanguageEnum languageEnum = LanguageUtil.getLanguageEnum(httpServletRequest);
            InformEntity informEntity = InfoConverter.toFollowUpEntity(request, languageEnum);
            //业务处理
            informService.addInform(informEntity);
            return ResultUtil.success(null);
        } catch (BizException e) {
            logger.error("=====BizException  NavigationFacadeImpl getNavigationExtendInfo request :" + request, e);
            return ResultUtil.fail(e.getMessage());
        } catch (Exception e) {
            logger.error("=====Exception  NavigationFacadeImpl  getNavigationInfo request : " + request, e);
            return ResultUtil.fail(BizErrorEnum.E001.getMessage());
        }
    }
}

