package ru.learnup.lesson20_springboot.events;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.learnup.lesson20_springboot.SpringBootApplication;
import ru.learnup.lesson20_springboot.annotations.LogMethod;
import ru.learnup.lesson20_springboot.annotations.WorkTime;

import java.util.Locale;

@Component
public class EventListener implements ApplicationListener<Event>, ApplicationContextAware {

    private static boolean find = false;

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
    public static boolean isFind() {
        return find;
    }
    @LogMethod
    @WorkTime
    @Override
    public void onApplicationEvent(Event event) {
        Locale locale = SpringBootApplication.locale;
        int desiredNumber = SpringBootApplication.hiddenNumber;
        if (event.getInputNumber() < desiredNumber) {
            System.out.println(context.getMessage("moreMessage", null, locale));
        } else if (event.getInputNumber() > desiredNumber) {
            System.out.println(context.getMessage("lessMessage", null, locale));
        } else {
            System.out.println(context.getMessage("findMessage", new Object[]{desiredNumber}, locale));
            find = true;
        }
    }
}
