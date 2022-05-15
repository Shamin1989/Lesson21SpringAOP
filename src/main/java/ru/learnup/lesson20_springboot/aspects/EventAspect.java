package ru.learnup.lesson20_springboot.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventAspect {
    private static final Logger log = LoggerFactory.getLogger(EventAspect.class);

    @Before("@annotation(ru.learnup.lesson20_springboot.annotations.LogMethod)")
    public void beforeAnnotation(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("Имя метода - {}, параметр метода - {} {}," +
                        " возвращаемое значение - {}",
                methodSignature.getName(), methodSignature.getParameterTypes(),
                methodSignature.getParameterNames(), methodSignature.getReturnType());
    }

    @After("@annotation(ru.learnup.lesson20_springboot.annotations.WorkTime)")
    public void afterAnnotation(JoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        long end = System.currentTimeMillis();
        log.info("Время работы метода {} - {} миллисекунд", methodSignature.getName(), end - start);
    }



}
