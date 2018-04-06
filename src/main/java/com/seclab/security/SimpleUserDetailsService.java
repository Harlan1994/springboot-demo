package com.seclab.security;

import com.seclab.domain.Role;
import com.seclab.domain.User;
import com.seclab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;

        try {
            user = userService.findUserByUsername(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("Failed to find user " + username + ".");
        }

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found.");
        } else {
            try {
                List<Role> roles = user.getRoles();
                user.setRoles(roles);
                return user;
            } catch (Exception e) {
                throw new UsernameNotFoundException("User " + username + " do not have any role(s).");
            }
        }
    }
}
