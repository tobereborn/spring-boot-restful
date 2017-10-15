package com.github.tbr.spring.config;


import com.github.tbr.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
         */
        /*auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select name, '1234',true from user where name=?")
                .authoritiesByUsernameQuery(
                        "select name, 'ROLE_USER' from user where name=?");*/
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .httpBasic()
                .realmName("spring")
                .and()
                .rememberMe()
                .tokenValiditySeconds(2419200)
                .key("spring_key")
                .and()
                .authorizeRequests()
                .antMatchers("/api/get").hasAnyAuthority("ROLE_USER")
                .antMatchers("/api/save").access("hasRole('ROLE_USER') and hasIpAddress('127.0.0.1')")
                .anyRequest().permitAll()
                .and()
                .requiresChannel()
                .antMatchers("/api/save").requiresSecure()
                .antMatchers("/").requiresInsecure();
    }
}
