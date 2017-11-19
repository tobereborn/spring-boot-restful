package com.github.tbr.spring.service;

import com.github.tbr.spring.service.dto.Oauth2Request;
import com.github.tbr.spring.service.dto.Oauth2Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Oath2Test {
    @Autowired
    private OAuth2RestTemplate template;

    @Test
    public void testTemplate() throws URISyntaxException {


        template.getAccessToken();

        Map<String, String> vars = new HashMap<>();
        Oauth2Response response;
        response = template.postForObject(new URI("http://localhost:8080/"), new Oauth2Request("1"), Oauth2Response.class);

        System.out.println(response);
    }
}
