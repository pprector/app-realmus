
package com.realmus.common.util;

import com.realmus.common.error.BizErrorEnum;
import com.realmus.common.error.BizException;
import com.realmus.repository.impl.InformRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送的工具类
 *
 * @author HUAWEI
 */
public class MailUtil {


    private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);

    /**
     * 发送邮件的主机
     */
    private static final String host = "smtp.163.com";


    /**
     * 创建简单的文本邮件
     *
     * @return
     * @throws Exception
     */
    public static void createSimpleMail(MailUtilDTO mailFrom) {
        try {
            // 创建邮件对象
            MimeMessage message = new MimeMessage(getSession());
            // 指明邮件的发件人
            message.setFrom(new InternetAddress(mailFrom.getSenderMail()));
            // 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailFrom.getRecipientEmail()));
            // 邮件的标题
            message.setSubject(mailFrom.getTitle());
            // 邮件的文本内容
            message.setContent(mailFrom.getContent(), "text/html;charset=UTF-8");
            // 返回创建好的邮件对象

            Transport.send(message);
        } catch (MessagingException e) {
            logger.error("邮箱发送失败");
            throw new BizException(BizErrorEnum.A001);
        }
    }


    /**
     * 根据 邮件服务器 获取Session
     *
     * @return
     */
    private static Session getSession() {
        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器  163 邮箱服务器
        properties.setProperty("mail.smtp.host", host);

        // 获取默认的 Session 对象。
        return Session.getDefaultInstance(properties);

    }
}