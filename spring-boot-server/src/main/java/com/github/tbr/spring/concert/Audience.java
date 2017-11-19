package com.github.tbr.spring.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(* com.github.tbr.spring.concert.Performance.perform(..))")
    public void perform() {
    }

    @Before("perform()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("perform()")
    public void takeSeat() {
        System.out.println("Taking seats");
    }

    @AfterReturning("perform()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("perform()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    @Around("perform()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable throwable) {
            System.out.println("Demanding a refund");
        }
    }
}
