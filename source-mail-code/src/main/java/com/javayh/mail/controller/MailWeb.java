package com.javayh.mail.controller;

import com.javayh.mail.entity.MailEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * <p>
 *
 * </p>
 *
 * @author Dylan
 * @version 1.0.0
 * @since 2021-02-24
 */
@Slf4j
@RestController
@RequestMapping(value = "/mail/")
public class MailWeb {

    private final JavaMailSender javaMailSender;

    private final TemplateEngine templateEngine;

    public MailWeb(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @PostMapping(value = "text")
    public void sendTextMail(MailEntity mail) {
        // 建立邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        // 发送人的邮箱
        message.setFrom("username");
        // 标题
        message.setSubject(mail.getTitle());
        // 发给谁 对方邮箱
        message.setTo(mail.getEmail());
        // 内容
        message.setText(mail.getContent());
        try {// 发送
            javaMailSender.send(message);
        } catch (MailException e) {
            log.error("纯文本邮件发送失败->message:{}", e.getMessage());
            throw new RuntimeException("邮件发送失败");
        }
    }

    public void sendTemplateMail(MailEntity mailDO) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            // 发送人的邮箱
            messageHelper.setFrom("username");
            // 发给谁 对方邮箱
            messageHelper.setTo(mailDO.getEmail());
            // 标题
            messageHelper.setSubject(mailDO.getTitle());
            // 使用模板thymeleaf
            Context context = new Context(LocaleContextHolder.getLocale());
            // 定义模板数据
            context.setVariables(mailDO.getAttachment());
            // 获取thymeleaf的html模板 指定模板路径
            String emailContent = templateEngine.process(mailDO.getTemplateName(),
                    context);
            messageHelper.setText(emailContent, true);
            // 发送邮件
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("模板邮件发送失败->message:{}", e.getMessage());
            throw new RuntimeException("邮件发送失败");
        }
    }

}
