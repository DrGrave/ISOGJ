package com.vidnichuk.isogj.impl.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vidnichuk.isogj.api.entity.MyUserCredentials;
import com.vidnichuk.isogj.api.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
    private final UserCredentialsService userCredentialsService;

    // TODO: 16.11.17 why autowired here?
    @Autowired
    public JWTLoginFilter(String url, AuthenticationManager authManager, UserCredentialsService userCredentialsService) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
        this.userCredentialsService = userCredentialsService;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
        MyUserCredentials creds = new ObjectMapper()
                .readValue(req.getInputStream(), MyUserCredentials.class);
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        creds.getUserLogin(),
                        creds.getUserPassword(),
                        Collections.emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
        TokenAuthenticationService
                .addAuthentication(res, auth.getName(), userCredentialsService.getUserByLogin(auth.getName()).getUser().getUserId());
    }
}
