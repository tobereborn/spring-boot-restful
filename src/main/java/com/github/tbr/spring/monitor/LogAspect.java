package com.github.tbr.spring.monitor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    //@Around("execution(* com.github.tbr.spring..*.getAllPosts(..))")
    @Around("@annotation(com.github.tbr.spring.monitor.Log)")
    public Object watch(ProceedingJoinPoint jp) {
        Object object = null;
        try {
            log.info("Monitor before for : {}", jp.getTarget().getClass());
            object = jp.proceed();
            log.info("Monitor after for :{}", jp.getTarget().getClass());
        } catch (Throwable throwable) {
            log.info("Monitor error: {}, for :{}", throwable, jp.getTarget().getClass());
            throw new RuntimeException(throwable);
        }
        return object;
    }
}