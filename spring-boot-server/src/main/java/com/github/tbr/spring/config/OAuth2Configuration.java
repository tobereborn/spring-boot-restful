package com.github.tbr.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableOAuth2Client
public class OAuth2Configuration {

    @Autowired
    private OAuth2ClientContext auth2ClientContext;


    @Bean
    public OAuth2ProtectedResourceDetails resourceDetails() {
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setClientId("123");
        resourceDetails.setClientSecret("123");
        resourceDetails.setAccessTokenUri("http://localhost:8080/oauth2/token");
        resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.query);
        return resourceDetails;
    }


    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate() {
        OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails(), auth2ClientContext);
        return template;
    }

}
