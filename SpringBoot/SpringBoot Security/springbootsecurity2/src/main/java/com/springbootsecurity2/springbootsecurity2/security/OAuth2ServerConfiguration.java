package com.springbootsecurity2.springbootsecurity2.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


// this is configuration of resource server
@Configuration
public class OAuth2ServerConfiguration {
    @Configuration
    @EnableResourceServer

    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(final HttpSecurity http) throws Exception {
            http.csrf().disable()
            .authorizeRequests()
            .anyRequest()
            .authenticated();
        }
    }
}
