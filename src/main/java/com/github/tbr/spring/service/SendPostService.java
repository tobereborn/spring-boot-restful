package com.github.tbr.spring.service;


import com.github.tbr.spring.domain.Post;
import com.github.tbr.spring.monitor.Monitor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SendPostService {

    @Monitor
    public void sendPosts(List<Post> posts) {
        System.out.println("Send: " + posts + " from " + this.getClass());
    }

}
