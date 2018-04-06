package com.seclab.domain;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/5
 * Time: 11:01
 * Description:
 */

@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;
}
