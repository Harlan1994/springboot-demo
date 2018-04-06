package com.seclab.security;

import com.seclab.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Component
public class SimpleAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SimpleUserDetailsService simpleUserDetailsService;

    @Autowired
    HttpSession httpSession;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = (User) simpleUserDetailsService.loadUserByUsername(username);

        System.out.println(user);
        if (user == null) {
            throw new BadCredentialsException("User " + username + " not exists.");
        }

        // TODO: 2018/1/24 先用明文比较方式比较密码
        if(!password.equals(user.getPassword())){
            throw new BadCredentialsException("Wrong password.");
        }

        httpSession.setAttribute("user", user);

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
