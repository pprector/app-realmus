package com.realmus.facade;

import com.realmus.common.result.ResultModel;
import com.realmus.facade.response.AboutUsResponse;
import com.realmus.facade.response.QueryHomeResponse;

/**
 * @author hkpeng
 * 关于我们 Facade 实现
 * @date 2021/12/28 - 9:19
 */

public interface AboutUsFacade {

    /**
     * 获取 关于我们  信息
     *
     * @param type
     * @return
     */
    ResultModel<AboutUsResponse> getHomeInfo(Integer type);
}
