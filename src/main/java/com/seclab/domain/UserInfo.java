package com.seclab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户的信息详情类封装
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private Long id;
    private boolean locked; // 用户是否被锁定，即账户不可用
    private String realName;
    private String avatar;
    private Date birthday;
}
