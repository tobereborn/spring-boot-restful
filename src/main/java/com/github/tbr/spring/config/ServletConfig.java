package com.github.tbr.spring.config;

import com.github.tbr.spring.servlet.GoodbyeServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

@Configuration
//@ComponentScan(basePackageClasses = {HelloServlet.class})
@ServletComponentScan(basePackageClasses = {GoodbyeServlet.class})
public class ServletConfig {

    @Autowired
    private Servlet servlet;

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(servlet, "/hello/*");
    }
}
