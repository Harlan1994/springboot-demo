package com.seclab.exception;

import com.seclab.domain.ResultEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/5
 * Time: 11:35
 * Description:
 */
@Data
public class UserNotFoundException extends RuntimeException {

    private String username;
    private Integer code;

    public UserNotFoundException(ResultEnum resultEnum, String username){
        super(resultEnum.getMessage());
        this.username = username;
        this.code = resultEnum.getCode();
    }
}
