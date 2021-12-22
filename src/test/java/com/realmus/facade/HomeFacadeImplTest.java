package com.realmus.facade;

import com.alibaba.fastjson.JSON;
import com.realmus.common.result.ResultModel;
import com.realmus.facade.response.QueryHomeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hkpeng
 * @date 2021/12/22 - 15:28
 */
@SpringBootTest
class HomeFacadeImplTest {
    @Autowired
    private HomeFacade homeFacade;

    @Test
    void getHomeInfo() {
        ResultModel<QueryHomeResponse> homeInfo = homeFacade.getHomeInfo(1);
        System.out.println(JSON.toJSONString(homeInfo, true));
    }
}