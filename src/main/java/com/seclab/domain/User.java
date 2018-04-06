package com.seclab.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Harlan1994 on 2017/11/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable, UserDetails {

    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private List<Role> roles;
    private UserInfo userInfo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles == null || roles.size() < 1) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList("");
        }
        StringBuilder commaBuilder = new StringBuilder();
        for (Role role : roles) {
            commaBuilder.append(role.getRoleName()).append(",");
        }
        String authorities = commaBuilder.substring(0, commaBuilder.length() - 1);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return userInfo.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
