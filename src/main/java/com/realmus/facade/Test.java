package com.realmus.facade;

import com.realmus.common.result.ResultModel;
import com.realmus.facade.request.User;
import com.realmus.service.TestFacadeImpl;
import org.apache.ibatis.jdbc.Null;

public interface Test {
    /**
     * 测试分页查询
     *
     * @return
     */
    ResultModel<User> pageUser();

    /**
     * 测试分页查询
     *
     * @return
     */
    ResultModel<Object> addUser(User user);
}
