package com.realmus.infrastructure;

import com.realmus.common.enums.EmailEnum;
import com.realmus.common.util.MailUtil;
import com.realmus.common.util.MailUtilDTO;
import com.realmus.domain.entity.InformEntity;
import com.realmus.infrastructure.converter.MailConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @author hkpeng
 * 邮箱服务
 * @date 2022/3/9 - 15:22
 */
@Service
public class MailboxService {


    private static final Logger logger = LoggerFactory.getLogger(MailboxService.class);

    @Value("${spring.mail.username}")
    private String  sendEmail;

    @Resource
    private JavaMailSender sender;

    /**
     * 邮箱通知 给业务员 Realmus 官方邮箱
     *
     * @param informEntity
     */
    public void NotifySalesman(InformEntity informEntity) {

        MailUtilDTO mailDTO = MailConverter.toMailUtilDTO(informEntity);
        try {
            switch (EmailEnum.getByType(mailDTO.getEmailType())) {
                case ORDINARY_MAIL:
                    SimpleMailMessage message = new SimpleMailMessage();
                    //标题
                    message.setSubject(mailDTO.getTitle());
                    // 设置邮件发送者
                    message.setFrom(sendEmail);
                    //接收者
                    message.setTo(mailDTO.getRecipientEmail());
                    // 设置邮件发送日期
                    message.setSentDate(new Date());
                    // 设置邮件的正文
                    message.setText(mailDTO.getContent());
                    // 发送邮件
                    sender.send(message);
                    break;
                case ENCLOSURE_MAIL:
                    break;
                case ORDINARY_IMAGE_MAIL:
                    break;
                default:
                    break;
            }
        } catch (MailException e) {
            logger.error("邮件发送失败：{0}", e);
        }



//        MailUtil.createSimpleMail(mailUtilDTO);


    }


    /**
     * 邮箱通知 给客户 Realmus 官方邮箱
     *
     * @param informEntity
     */
    public void NotifyCustomer(InformEntity informEntity) {

    }

}
