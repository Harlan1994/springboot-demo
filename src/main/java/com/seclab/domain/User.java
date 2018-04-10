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
import java.util.Date;
import java.util.Set;

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
    private boolean locked; // 用户是否被锁定，即账户不可用
    private String realName;
    private String avatar;
    private String birthday;
    private Set<Role> roles;

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

    // 用户是否过期，这里不考虑过期的问题
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return locked;
    }

    // 用户授权是否过期，这里不考虑
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 是否开启，这里也不考虑
    @Override
    public boolean isEnabled() {
        return true;
    }
}
