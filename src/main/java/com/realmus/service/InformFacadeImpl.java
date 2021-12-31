package com.realmus.service;

import com.realmus.common.result.ResultModel;
import com.realmus.common.util.PageResult;
import com.realmus.domain.service.InformService;
import com.realmus.facade.InformFacade;
import com.realmus.facade.request.PageInformRequest;
import com.realmus.facade.response.PageInformResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/30 - 15:41
 */
@RestController
@Api(tags = "短信通知数据分页查询")
public class InformFacadeImpl  implements InformFacade {

    @Autowired
    private InformService informService;

    @ApiOperation(value = "短信通知数据分页查询", httpMethod = "POST")
    @ApiImplicitParam(name = "type", value = "语言类型", required = true, dataType = "int")
    @Override
    @GetMapping("/inform/{type}")
    public ResultModel<PageResult<PageInformResponse>> pageInform(PageInformRequest request) {
        PageResult<Object> objectPageResult = informService.pageInfo(request);

        return null;
    }
}
