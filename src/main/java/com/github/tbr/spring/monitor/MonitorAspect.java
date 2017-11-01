package com.github.tbr.spring.monitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MonitorAspect {

    //@Around("execution(* com.github.tbr.spring..*.getAllPosts(..))")
    @Around("@annotation(com.github.tbr.spring.monitor.Monitor)")
    public Object watch(ProceedingJoinPoint jp) {
        Object object = null;
        try {
            System.out.println("Before:" + jp.getTarget().getClass());
            object = jp.proceed();
            System.out.println("After:" + jp.getTarget().getClass());
        } catch (Throwable throwable) {
            System.out.println("Error:" + throwable);
        }
        return object;
    }
}