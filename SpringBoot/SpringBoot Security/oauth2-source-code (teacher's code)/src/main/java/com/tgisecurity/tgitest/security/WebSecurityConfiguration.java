package com.tgisecurity.tgitest.security;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;



@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailService userDetailsService;

    private final AccountAuthenticationProvider accountAuthenticationProvider;

    public WebSecurityConfiguration(final CustomUserDetailService userDetailsService, final AccountAuthenticationProvider accountAuthenticationProvider) {
        this.userDetailsService = userDetailsService;
        this.accountAuthenticationProvider = accountAuthenticationProvider;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(accountAuthenticationProvider);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .cors()
//                .and()
                .csrf()
                .csrfTokenRepository(this.getCsrfTokenRepository()).and().anonymous().disable()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll();

        http.headers()
                .frameOptions()
                .and()
                .httpStrictTransportSecurity()
                .and()
                .xssProtection()
                .xssProtectionEnabled(true)
                .and()
                .addHeaderWriter(new StaticHeadersWriter("HttpOnly", "true"));

        http.sessionManagement()
                .sessionFixation()
                .migrateSession()
                .maximumSessions(1);
    }

    private CsrfTokenRepository getCsrfTokenRepository() {
        CookieCsrfTokenRepository tokenRepository = CookieCsrfTokenRepository.withHttpOnlyFalse();
        tokenRepository.setCookiePath("/");
        return tokenRepository;
    }


    @Bean
    public FilterRegistrationBean<ShallowEtagHeaderFilter> shallowEtagHeaderFilter() {
        FilterRegistrationBean<ShallowEtagHeaderFilter> filterRegistrationBean
                = new FilterRegistrationBean<>(new ShallowEtagHeaderFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("etagFilter");
        return filterRegistrationBean;
    }
}