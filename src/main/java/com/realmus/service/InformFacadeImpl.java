package com.realmus.service;

import com.realmus.common.result.ResultModel;
import com.realmus.facade.InformFacade;
import com.realmus.facade.request.InformRequest;
import com.realmus.facade.request.PageInformRequest;
import com.realmus.facade.response.PageInformResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hkpeng
 * @date 2021/12/30 - 15:41
 */

public class InformFacadeImpl  implements InformFacade {
    @Override
    public ResultModel<PageInformResponse> pageInform(PageInformRequest request) {
        return null;
    }

    @Override
    public ResultModel<PageInformResponse> addInform(HttpServletRequest httpServletRequest, InformRequest request) {
        return null;
    }
}

