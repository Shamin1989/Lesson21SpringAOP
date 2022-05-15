package ru.learnup.lesson20_springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.lesson20_springboot.aspects.EventAspect;
import ru.learnup.lesson20_springboot.events.EventListener;
import ru.learnup.lesson20_springboot.events.EventPublisher;

import java.util.Locale;
import java.util.Scanner;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public final static Locale locale = Locale.getDefault();

    public final static int hiddenNumber = (int) (Math.random() * 1000);

    private static final Logger log = LoggerFactory.getLogger(SpringBootApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootApplication.class, args);

        EventPublisher publisher = context.getBean(EventPublisher.class);

        Scanner scanner = new Scanner(System.in);
        int inputNumber;
        System.out.println(context.getMessage("hiMessage", null, locale));

        while (!EventListener.isFind()) {
            System.out.print(context.getMessage("inputMessage", null, locale));
            inputNumber = scanner.nextInt();
            publisher.publishEvent(inputNumber);
        }
    }

}
