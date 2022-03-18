package com.realmus.common.util;

import com.realmus.common.enums.EmailEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author hkpeng
 * @date 2022/3/10 - 10:07
 */
@Data
public class MailUtilDTO {
    /**
     * 收件人电子邮箱
     **/
    private String recipientEmail;

    /**
     * 邮件标题
     */
    private String title="测试标题";

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 邮件附件-文件上传后的地址
     */
    private String attachment;

    /**
     * 邮件附件名称
     */
    private String attachmentName;

    /**
     * 图片地址
     */
    private List<String> image;

    /**
     * 邮件类型{@link com.realmus.common.enums.EmailEnum}
     */
    @NotNull
    private Integer emailType;

}
