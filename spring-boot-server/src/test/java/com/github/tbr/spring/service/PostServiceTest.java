package com.github.tbr.spring.service;

import com.github.tbr.spring.Application;
import com.github.tbr.spring.domain.Post;
import com.github.tbr.spring.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;


    @Test
    public void testGetAllUsers(){
        List<User> users=userService.getAllUsers();
        System.out.println(users);
    }

    @Test
    public void testGetAllPosts() {
        List<Post> posts = postService.getAllPosts();
        System.out.println(posts);
    }

    @Test
    public void testGetUser(){
        userService.getUser("wj");
    }
}
