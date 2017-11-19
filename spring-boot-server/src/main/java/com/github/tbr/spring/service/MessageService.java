package com.github.tbr.spring.service;


import com.github.tbr.spring.domain.Post;
import com.github.tbr.spring.monitor.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MessageService {

    @Log
    public void sendPosts(List<Post> posts) {
        log.info("Send: {} from {}", posts, this.getClass());
    }

}
