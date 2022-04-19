package com.realmus;

import com.realmus.domain.entity.InformEntity;
import com.realmus.infrastructure.MailboxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@SpringBootTest
class RealmusAppApplicationTests {

    @Resource
    private JavaMailSender sender;

    @Test
    void contextLoads() {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("这是一封测试邮件2");
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("15617889809@163.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
//        message.setTo("10*****16@qq.com,12****32*qq.com");
        message.setTo("pzj0517@163.com,");
        // 设置邮件抄送人，可以有多个抄送人
//        message.setCc("12****32*qq.com");
        // 设置隐秘抄送人，可以有多个
//        message.setBcc("7******9@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText("这是测试邮件的正文2");
        // 发送邮件
        sender.send(message);

    }
    @Value("${spring.mail.username}")
    private String  sendEmail;


    @Test
    void test02(){
        System.out.println(sendEmail);
    }

    /**
     * 发送带附件的邮件
     */
    @Test
    public void sendAttachFileMail() throws MessagingException {
        MimeMessage mimeMessage = sender.createMimeMessage();
        // true表示构建一个可以带附件的邮件对象
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("这是一封测试邮件");
        helper.setFrom("79******9@qq.com");
        helper.setTo("10*****16@qq.com");
        //helper.setCc("37xxxxx37@qq.com");
        //helper.setBcc("14xxxxx098@qq.com");
        helper.setSentDate(new Date());
        helper.setText("这是测试邮件的正文");
        // 第一个参数是自定义的名称，后缀需要加上，第二个参数是文件的位置
        helper.addAttachment("资料.xlsx",new File("/Users/gamedev/Desktop/测试数据 2.xlsx"));
        sender.send(mimeMessage);
    }

    /**
     * 正文中带图片的邮件
     * @throws MessagingException
     */
    @Test
    public void sendImgResMail() throws MessagingException {
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是一封测试邮件");
        helper.setFrom("79*****39@qq.com");
        helper.setTo("10****6@qq.com");
        //helper.setCc("37xxxxx37@qq.com");
        //helper.setBcc("14xxxxx098@qq.com");
        helper.setSentDate(new Date());
        // src='cid:p01' 占位符写法 ，第二个参数true表示这是一个html文本
        helper.setText("<p>hello 大家好，这是一封测试邮件，这封邮件包含两种图片，分别如下</p><p>第一张图片：</p><img src='cid:p01'/><p>第二张图片：</p><img src='cid:p02'/>",true);
        // 第一个参数指的是html中占位符的名字，第二个参数就是文件的位置
        helper.addInline("p01",new FileSystemResource(new File("/Users/gamedev/Desktop/压缩.jpeg")));
        helper.addInline("p02",new FileSystemResource(new File("/Users/gamedev/Desktop/瑞文.jpg")));
        sender.send(mimeMessage);
    }

    @Resource
    private MailboxService service;


    @Test
    void test09(){
        InformEntity informEntity = new InformEntity();
        informEntity.setMessage("测试消息009999");
        informEntity.setEmail("1509621999@qq.com");
        informEntity.setCompanyName("公司名称");
        informEntity.setName("name");
        informEntity.setPhone("15617889809");
        service.NotifySalesman(informEntity);
    }

}
