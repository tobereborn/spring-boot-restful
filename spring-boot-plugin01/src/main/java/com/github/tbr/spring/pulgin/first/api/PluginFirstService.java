package com.github.tbr.spring.pulgin.first.api;


import com.github.tbr.spring.dto.Message;
import com.github.tbr.spring.repository.PostRepository;
import com.github.tbr.spring.spi.Consumer;
import com.github.tbr.spring.spi.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;


@Slf4j
public class PluginFirstService implements Producer, Consumer {

    @Autowired
    private PostRepository postRepository;

    private Random random = new Random();

    @Override
    public void consume(Message message) {
        log.info("{} consume: {}", this.getClass(), message);
    }

    @Override
    public Message produce() {
        int id = random.nextInt();
        String content = String.format("content: %s", id);
        return new Message(random.nextInt(), content);
    }

    public String toString() {
        return "plugin01";
    }
}
