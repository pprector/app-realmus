package com.realmus.infrastructure;

import com.realmus.common.util.MailUtil;
import com.realmus.common.util.MailUtilDTO;
import com.realmus.domain.entity.InformEntity;
import com.realmus.infrastructure.converter.MailConverter;
import org.springframework.stereotype.Component;

/**
 * @author hkpeng
 * 邮箱服务
 * @date 2022/3/9 - 15:22
 */
@Component
public class MailboxService {

    /**
     * 邮箱通知 给业务员 Realmus 官方邮箱
     *
     * @param informEntity
     */
    public void NotifySalesman(InformEntity informEntity) {
        MailUtilDTO mailUtilDTO = MailConverter.toMailUtilDTO(informEntity);
        MailUtil.createSimpleMail(mailUtilDTO);


    }


    /**
     * 邮箱通知 给客户 Realmus 官方邮箱
     *
     * @param informEntity
     */
    public void NotifyCustomer(InformEntity informEntity) {

    }

}
