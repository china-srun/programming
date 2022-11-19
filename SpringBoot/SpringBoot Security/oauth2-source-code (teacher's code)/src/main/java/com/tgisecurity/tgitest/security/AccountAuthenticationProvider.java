package com.tgisecurity.tgitest.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private final CustomUserDetailService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    public AccountAuthenticationProvider(final CustomUserDetailService userDetailsService, final PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
//            System.out.println("================");
        //    System.out.println(passwordEncoder.encode("testingTest"));
    }

    @Override
    protected Authentication createSuccessAuthentication(Object principal, Authentication authentication, UserDetails user) {
        return super.createSuccessAuthentication(principal, authentication, user);
    }
    
    @Override
    protected void additionalAuthenticationChecks(final UserDetails userDetails, final UsernamePasswordAuthenticationToken token)
            throws AuthenticationException {
        if (token.getCredentials() == null || userDetails.getPassword() == null) {
            throw new BadCredentialsException("Credentials may not be null.");
        }

        if (!passwordEncoder.matches((String) token.getCredentials(), userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid credentials.");
        }
    }

    @Override
    protected UserDetails retrieveUser(final String username, final UsernamePasswordAuthenticationToken token) throws AuthenticationException {
        return userDetailsService.loadUserByUsername(username);
    }

}