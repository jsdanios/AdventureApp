package com.tts.AdventureApp;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class AdventureAppApplication {

    @Configuration
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.httpBasic().and().authorizeRequests().antMatchers("/index.html", "/", "/home", "/login").permitAll()
                    .anyRequest().authenticated().and().csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        }
    }

    @RequestMapping("/")
    @CrossOrigin(origins="http://localhost:4200", maxAge=3600)
    public Message home() {
        return new Message("Hello World");
    }

    public static void main(String[] args) {
        SpringApplication.run(AdventureAppApplication.class, args);
    }
}

class Message {
    private String id = UUID.randomUUID().toString();
    private String content;

    public Message(String content) {
        this.setContent(content);
    }

    public Message() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
	
}