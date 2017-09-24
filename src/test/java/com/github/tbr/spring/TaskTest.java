package com.github.tbr.spring;

import com.github.tbr.spring.service.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {
    private static Logger log = LoggerFactory.getLogger(TaskTest.class);

    @Autowired
    private Task task;

    @Test
    public void test() throws InterruptedException, ExecutionException {
        Future<String> eat = task.eat();
        Future<String> sleep = task.sleep();
        while (true) {
            if (eat.isDone() && sleep.isDone()) {
                log.info("eat: {}", eat.get());
                log.info("eat: {}", sleep.get());
                TimeUnit.SECONDS.sleep(1);
                break;
            }
        }
    }

    @Test
    public void test2() throws Exception {
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            throw new Exception(e.getMessage(),e);
        }

    }
}
