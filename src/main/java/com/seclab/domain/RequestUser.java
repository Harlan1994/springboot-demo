package com.seclab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/9
 * Time: 11:15
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUser implements Serializable {

    private String username;
    private String password;
    private String realName;
    private String birthday;
}
