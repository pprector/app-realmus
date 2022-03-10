package com.realmus.domain.service;

import com.realmus.domain.entity.InformEntity;
import com.realmus.domain.repository.InformRepository;
import com.realmus.infrastructure.MailboxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hkpeng
 * 表单 服务
 * @date 2022/3/9 - 14:43
 */
@Service
public class InformService {
    private static final Logger logger = LoggerFactory.getLogger(NavigationService.class);

    @Autowired
    private InformRepository informRepository;

    @Autowired
    private MailboxService mailboxService;

    /**
     * 表单提交
     * 邮件发送
     */
    public void addInform(InformEntity informEntity)  {
        //1. 数据入库
        informRepository.addInform(informEntity);
        //2. 通知业务员
        mailboxService.NotifySalesman(informEntity);
        //3. 通知客户
        mailboxService.NotifyCustomer(informEntity);
    }
}
