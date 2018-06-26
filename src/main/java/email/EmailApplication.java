package email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.Context;

@SpringBootApplication
public class EmailApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private EmailHtmlSender emailHtmlSender;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(email.EmailApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        /*String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
        }*/
        Context context = new Context();
        context.setVariable("title", "Lorem Ipsum");
        context.setVariable("description", "Lorem Lorem Lorem");
        EmailStatus emailStatus = emailHtmlSender.send(
                "xxxxx@gmail.com",
                "Title of email",
                "mailTemplate",context);
        System.out.println("Status " + emailStatus.getErrorMessage());
    }
}
