package com.realmus.infrastructure;

import com.realmus.domain.entity.InformEntity;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author hkpeng
 * 邮箱服务
 * @date 2022/3/9 - 15:22
 */
@Service
public class MailboxService {


    private static final Logger logger = LoggerFactory.getLogger(MailboxService.class);

    @Value("${spring.mail.username}")
    private String sendEmail;

    @Value("${spring.mail.recipients}")
    private String recipients;

    @Resource
    private JavaMailSender sender;

    /**
     * 邮箱通知 给业务员 Realmus 官方邮箱
     *
     * @param informEntity
     */
    public void NotifySalesman(InformEntity informEntity) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            //标题
            message.setSubject("【realmus-" + informEntity.getName() + "】");
            // 设置邮件发送者
            message.setFrom(sendEmail);
            //接收者
            message.setTo(recipients);
            // 设置邮件发送日期
            message.setSentDate(new Date());
            // 设置邮件的正文
            StringBuilder text = new StringBuilder("name: " + informEntity.getName());
            if (StringUtils.isNotBlank(informEntity.getCompanyName())) {
                text.append("\n companyName : " + informEntity.getCompanyName());
            }
            if (StringUtils.isNotBlank(informEntity.getEmail())) {
                text.append("\n email : " + informEntity.getEmail());
            }
            if (StringUtils.isNotBlank(informEntity.getPhone())) {
                text.append("\n phone : " + informEntity.getPhone());
            }
            if (StringUtils.isNotBlank(informEntity.getMessage())) {
                text.append("\n message : " + informEntity.getMessage());
            }
            message.setText(text.toString());
            // 发送邮件
            sender.send(message);
            logger.info("main : "+informEntity.getName()+"成功");
        } catch (MailException e) {
            logger.error("邮件发送失败：" + e);
        }
    }


    /**
     * 邮箱通知 给客户 Realmus 官方邮箱
     *
     * @param informEntity
     */
    public void NotifyCustomer(InformEntity informEntity) {

    }

}
