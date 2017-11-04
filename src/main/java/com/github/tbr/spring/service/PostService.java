package com.github.tbr.spring.service;


import com.github.tbr.spring.domain.Post;
import com.github.tbr.spring.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class PostService {

    private PostRepository postRepository;
    private SendPostService sendPostService;


    @Autowired
    public PostService(PostRepository postRepository, SendPostService sendPostService) {
        this.postRepository = postRepository;
        this.sendPostService = sendPostService;
    }

    @Transactional(readOnly = true)
    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        sendPostService.sendPosts(posts);
        log.info("get posts: {}", posts);
        return posts;
    }

    @Transactional(readOnly = true)
    public Page<Post> getPageablePosts(int page, int size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
        return postRepository.findAll(pageable);
    }
}
