package com.seclab.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Role implements Serializable {
    private Long id;

    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}