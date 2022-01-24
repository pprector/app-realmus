package com.realmus.facade;

import com.alibaba.fastjson.JSON;
import com.realmus.common.result.ResultModel;
import com.realmus.domain.repository.NavigationRepository;
import com.realmus.domain.service.NavigationService;
import com.realmus.facade.request.NavExtendRequest;
import com.realmus.facade.response.NavRDResponse;
import com.realmus.facade.response.NavigationExtendResponse;
import com.realmus.facade.response.NavigationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/30 - 15:12
 */
@SpringBootTest
public class QueryNavigationFacadeImplTest {
    @Autowired
    private NavigationFacade navigationFacade;
    @Autowired
    private NavigationRepository navigationRepository;

    @Autowired
    private NavigationService navigationService;

    @Test
    public void getRDInfo() {
        ResultModel<List<NavigationResponse>> navigationInfo = navigationFacade.getNavigationInfo(null);
        System.out.println(JSON.toJSONString(navigationInfo, true));
    }

    @Test
    public void getNavigationExtendInfo(){
        NavExtendRequest request = new NavExtendRequest();
        request.setNavId("1640068311");
        ResultModel<NavigationExtendResponse> navigationExtendInfo = navigationFacade.getNavigationExtendInfo(request,null);
        System.out.println(JSON.toJSONString(navigationExtendInfo, true));
    }
}
