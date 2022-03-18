package com.realmus.infrastructure.converter;

import com.realmus.common.util.MailUtilDTO;
import com.realmus.domain.entity.InformEntity;

/**
 * @author hkpeng
 * @date 2022/3/10 - 10:28
 */

public class MailConverter {

    /**
     * 邮件发送转换
     * <p>
     * 给业务员发
     *
     * @param informEntity
     * @return
     */
    public static MailUtilDTO toMailUtilDTO(InformEntity informEntity) {
        MailUtilDTO mailUtilDTO = new MailUtilDTO();
        mailUtilDTO.setRecipientEmail(informEntity.getEmail());
        mailUtilDTO.setContent(informEntity.getMessage());
        mailUtilDTO.setEmailType(informEntity.getEmailType());
        return mailUtilDTO;
    }
}
