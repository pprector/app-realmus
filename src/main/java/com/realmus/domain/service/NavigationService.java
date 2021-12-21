package com.realmus.domain.service;

import com.realmus.domain.entity.NavigationEntity;
import com.realmus.service.TestFacadeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hkpeng
 * @date 2021/12/21 - 10:52
 */

@Service
public class NavigationService {
    private static final Logger logger = LoggerFactory.getLogger(TestFacadeImpl.class);

    /**
     * 查询导航栏
     *
     * @return
     */
    public List<NavigationEntity> getNavigationInfo() {
        logger.info("=====NavigationFacadeImpl getNavigationInfo request : ");
        //查询出所有数据




        return null;
    }
}
