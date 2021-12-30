package com.realmus.facade;

import com.realmus.common.result.ResultModel;
import com.realmus.facade.request.PageInformRequest;
import com.realmus.facade.response.PageInformResponse;

/**
 * @author hkpeng
 * 短信息 - 通知记录分页查询
 * @date 2021/12/30 - 15:18
 */

public interface InformFacade {

    /**
     * 1. 短信通知数据分页查询
     * 2. 支持邮箱, 手机号 模糊查询
     * 3. 可以百度 看看PageHelper  怎么实现 分页查询 --->自己写工具类实现也可
     * 4. 要求返回 总记录数, 总页码,
     * 5. 数据库对应 inform数据库 ,
     * <p>
     * 6. 代码写完先不要提交. 该功能不涉及和其他代码交互,
     *
     * @param request
     * @return
     */
    ResultModel<PageInformResponse> pageInform(PageInformRequest request);
}
