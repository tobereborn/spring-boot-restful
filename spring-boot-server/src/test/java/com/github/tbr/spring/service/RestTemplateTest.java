package com.github.tbr.spring.service;

import com.github.tbr.spring.domain.Post;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestTemplateTest {

    @LocalServerPort
    private int port = 8080;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testHomePage() {
        String response = testRestTemplate.getForObject("/", String.class);
        System.out.println(response);
        Assert.assertNotNull(response);
    }

    @Test
    public void testGetAllPosts() {
        Post[] response = testRestTemplate.getForObject("/api/all", Post[].class);
        for (Post post : response) {
            System.out.println(post);
        }

        ResponseEntity<Post[]> posts = restTemplate.getForEntity("http://localhost:" + port + "/api/all", Post[].class);
        System.out.println(posts.getStatusCode());
        System.out.println(posts.getHeaders());
        System.out.println(posts.getStatusCodeValue());
        System.out.println(posts.getBody());
    }
}