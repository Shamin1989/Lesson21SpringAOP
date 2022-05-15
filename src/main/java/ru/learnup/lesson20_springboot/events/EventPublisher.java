package ru.learnup.lesson20_springboot.events;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.learnup.lesson20_springboot.annotations.LogMethod;
import ru.learnup.lesson20_springboot.annotations.WorkTime;

@Component
public class EventPublisher implements ApplicationContextAware {

    private ApplicationContext context;
    @LogMethod
    @WorkTime
    public void publishEvent(int inputNumber) {
        context.publishEvent(new Event(inputNumber));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
