package com.seclab.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/4
 * Time: 10:34
 * Description:
 */
@Data
public class User implements Serializable {
    private Long id;
    private String username;
}
