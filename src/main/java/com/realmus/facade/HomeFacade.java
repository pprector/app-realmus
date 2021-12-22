package com.realmus.facade;

import com.realmus.common.result.ResultModel;
import com.realmus.facade.response.QueryHomeResponse;

/**
 * @author hkpeng
 * 网站首页 数据操作接口
 * @date 2021/12/22 - 11:45
 */

public interface HomeFacade {

    /**
     * 获取 Home 信息
     *
     * @param type
     * @return
     */
    ResultModel<QueryHomeResponse> getHomeInfo(Integer type);

}
