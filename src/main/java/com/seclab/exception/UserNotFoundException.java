package com.seclab.exception;

import com.seclab.domain.ResultEnum;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/5
 * Time: 11:35
 * Description:
 */
public class UserNotFoundException extends RuntimeException {

    private Integer code;
    public UserNotFoundException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
