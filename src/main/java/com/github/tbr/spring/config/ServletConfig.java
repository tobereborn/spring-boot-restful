package com.github.tbr.spring.config;

import com.github.tbr.spring.servlet.GoodbyeServlet;
import com.github.tbr.spring.servlet.HelloFilter;
import com.github.tbr.spring.servlet.HelloServlet;
import com.github.tbr.spring.servlet.SimpleListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackageClasses = {HelloServlet.class})
//@ServletComponentScan(basePackageClasses = {GoodbyeServlet.class})
public class ServletConfig {


    @Bean
    public ServletRegistrationBean helloServletRegistrationBean() {
        return new ServletRegistrationBean(new HelloServlet(), "/hello/*");
    }

    @Bean
    public ServletRegistrationBean goodbyeServletRegistrationBean() {
        return new ServletRegistrationBean(new GoodbyeServlet(), "/goodbye/*");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new HelloFilter());
        registrationBean.addUrlPatterns("/hello/*");
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<SimpleListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SimpleListener> registrationBean = new ServletListenerRegistrationBean<SimpleListener>();
        registrationBean.setListener(new SimpleListener());
        return registrationBean;
    }
}
