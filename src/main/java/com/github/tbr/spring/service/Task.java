package com.github.tbr.spring.service;


import com.github.tbr.spring.config.ExecutorProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Component
public class Task {
    private static final Logger log = LoggerFactory.getLogger(Task.class);

    @Autowired
    private ExecutorProperties properties;

    @Async("simpleExecutor")
    public Future<String> eat() throws InterruptedException {
        System.out.println("properities: " + properties.getHost());
        if (properties.getHost() != null) {
            log.info("properties: {}", properties);
        }
        log.info("start to eating");
        long start = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        long end = System.currentTimeMillis();
        log.info("stop eating");
        return new AsyncResult<>("i am full");
    }

    @Async("advancedExecutor")
    public Future<String> sleep() throws InterruptedException {
        log.info("start to sleeping");
        long start = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        long end = System.currentTimeMillis();
        log.info("stop sleeping");
        return new AsyncResult<>("i am wakeup");
    }


}
