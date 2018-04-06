package com.seclab.exception;

import com.seclab.domain.Result;
import com.seclab.domain.ResultEnum;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/5
 * Time: 11:04
 * Description:
 */

@Data
public class LoginException extends RuntimeException {

    private Integer code;

    public LoginException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
