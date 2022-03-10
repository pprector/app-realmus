package com.realmus.common.util;

import lombok.Data;

/**
 * @author hkpeng
 * @date 2022/3/10 - 10:07
 */
@Data
public class MailUtilDTO {
    // 收件人电子邮箱
    private String recipientEmail;

    // 发件人电子邮箱
    private String SenderMail;

    //邮件标题
    private String title;

    //邮件内容
    private String content;
}
