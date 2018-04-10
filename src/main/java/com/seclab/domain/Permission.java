package com.seclab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/10
 * Time: 20:07
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {

    public Permission(String permissionName) {
        this.permissionName = permissionName;
    }

    private Long id;
    private String permissionName;
}
