package com.realmus.domain.service;

import com.realmus.common.util.PageResult;
import com.realmus.facade.request.PageInformRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author k
 * @data 2021/12/31
 */
@Service
public class InformService {
    private static final Logger logger = LoggerFactory.getLogger(InformService.class);


    public PageResult<Object> pageInfo(PageInformRequest request) {
        return null;
    }
}
