package com.realmus.facade;

import com.alibaba.fastjson.JSON;
import com.realmus.common.result.ResultModel;
import com.realmus.facade.response.PageNavigationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hkpeng
 * @date 2021/12/21 - 14:53
 */
@SpringBootTest
class NavigationFacadeImplTest {
    @Autowired
    private NavigationFacade navigationFacade;

    @Test
    void getNavigationInfo() {
        ResultModel<List<PageNavigationResponse>> navigationInfo = navigationFacade.getNavigationInfo(1);
        System.out.println(JSON.toJSONString(navigationInfo,true));
    }
}