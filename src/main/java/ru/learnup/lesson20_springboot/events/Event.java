package ru.learnup.lesson20_springboot.events;

import org.springframework.context.ApplicationEvent;
import ru.learnup.lesson20_springboot.annotations.LogMethod;
import ru.learnup.lesson20_springboot.annotations.WorkTime;

public class Event extends ApplicationEvent {

    private int inputNumber;

    public Event(int inputNumber) {
        super(inputNumber);
        this.inputNumber = inputNumber;
    }
    @LogMethod
    @WorkTime
    public int getInputNumber() {
        return inputNumber;
    }
}
