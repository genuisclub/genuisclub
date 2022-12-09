package club.genuis.web.service;

import club.genuis.web.base.RespConstant;
import club.genuis.web.entity.MailRecord;
import club.genuis.web.mapper.MailRecordMapper;
import club.genuis.web.utils.RandomUtil;
import club.genuis.web.utils.RegexUtil;
import club.genuis.web.utils.WebUtil;
import com.btprice.middleware.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class MailService {

    @Value("${spring.mail.from}")
    private String mailFrom;

    @Resource
    private RedisService redisService;

    @Autowired
    private JavaMailSender mailSender;
    @Resource
    private MailRecordMapper mailRecordMapper;

    private final static String EMAIL_PREFIX_COUNT = "validity_count_";

    private final static String EMAIL_VALIDITY_CODE_PREFIX = "code_";

    private final static int MAX_VALIDITY_COUNT = 10;

    private Logger log = LoggerFactory.getLogger("mail");


    public int sendHtmlMail(String to, Locale locale) {
        if (!RegexUtil.checkEmail(to)) {
            return RespConstant.EMAIL_FORMAT_ERROR;
        }
        if (redisService.incr(EMAIL_PREFIX_COUNT + to) > MAX_VALIDITY_COUNT) {
            if (redisService.ttl(EMAIL_PREFIX_COUNT + to) == -1) {
                redisService.expire(EMAIL_PREFIX_COUNT + to, 86400);
            }
            return RespConstant.EMAIL_VALIDITY_BE_LOCKED;
        }
        if (redisService.ttl(EMAIL_PREFIX_COUNT + to) == -1) {
            redisService.expire(EMAIL_PREFIX_COUNT + to, 86400);
        }
        long ttl = redisService.ttl(EMAIL_VALIDITY_CODE_PREFIX + to);
        if (ttl > 270) {
            return RespConstant.EMAIL_VALIDITY_CODE_TO_FREQUENTLY;
        }
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom(mailFrom);
            messageHelper.setTo(to);
            messageHelper.setSubject("register code");
            String code = RandomUtil.genEmailValidityCode();
            redisService.setString(EMAIL_VALIDITY_CODE_PREFIX + to, code, 300);
            messageHelper.setText(getContent(code, locale), true);
            mailSender.send(mimeMessage);
            saveRecord(to, code);
            return RespConstant.SUCCESS;
        } catch (MailException e) {
            log.error("mail", e);
            return RespConstant.EMAIL_SEND_FAIL;
        } catch (MessagingException e) {
            log.error("mail", e);
            return RespConstant.EMAIL_SEND_FAIL;
        }
    }

    public int checkValidityCode(String email, String code) {
        long incr = redisService.incr(EMAIL_PREFIX_COUNT + email);
        if (incr == 1) {
            redisService.expire(EMAIL_PREFIX_COUNT + email, 86400);
        }
        if (incr > MAX_VALIDITY_COUNT) {
            return RespConstant.EMAIL_VALIDITY_BE_LOCKED;
        }
        String cacheCode = redisService.getString(EMAIL_VALIDITY_CODE_PREFIX + email);
        if (StringUtils.hasText(cacheCode)) {
            if (cacheCode.equals(code)) {
                redisService.delete(EMAIL_PREFIX_COUNT + email);
                return RespConstant.SUCCESS;
            }
            return RespConstant.EMAIL_VALIDITY_CODE_NOT_MATCH;
        } else {
            return RespConstant.EMAIL_VALIDITY_CODE_NOT_EXITSTS;
        }
    }


    private String getContent(String code, Locale locale) {
//        String contentCN = "<html>\n" +
//                "<body>\n" +
//                " <h2>你的的邮件验证码是：%s 有效期时间为5分钟</h2>" +
//                "</body>" +
//                "<html>";
        String contentEN = "<html>\n" +
                "<body>\n" +
                " <h2>Your Verification Code is: %s </h2>" +
                " <p>Hello,</p>" +
                " <p>Thanks for signing up. Please verify your email address by going back to your sign-up page and insert the code above to verify your identity.</p>" +
                " <p>This email is automatically sent and doesn`t receive responses. </p>" +
                " <p>Best Regards,</p>" +
                " <p>Element.Black Team</p>" +
                " </body>" +
                "<html>";
        switch (locale.getLanguage()) {
            case "zh":
                return String.format(contentEN, code);
            case "en":
                return String.format(contentEN, code);
            default:
                return String.format(contentEN, code);
        }
    }

    public void saveRecord(String to, String code) {
        MailRecord record = new MailRecord();
        record.setContent(code);
        record.setCreateTm(LocalDateTime.now());
        record.setMail(to);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        record.setIp(WebUtil.getRemoteIpAddr(request));
        mailRecordMapper.insert(record);
    }
}
