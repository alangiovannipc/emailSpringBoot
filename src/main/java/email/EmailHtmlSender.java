package email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class EmailHtmlSender {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private TemplateEngine templateEngine;

    /*@Autowired
    private TemplateResolver resolver;*/


    public EmailStatus send(String to, String subject, String templateName, Context context) {
        /*TemplateResolver resolver = new TemplateResolver();
        resolver.setResourceResolver(new SpringResourceResourceResolver());
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(StandardTemplateModeHandlers.LEGACYHTML5.getTemplateModeName());
        resolver.setCacheable(false);
        resolver.setCharacterEncoding("UTF-8");

        templateEngine.setTemplateResolver(resolver);*/
        String body = templateEngine.process(templateName, context);
        return emailSender.sendHtml(to, subject, body);
    }
}