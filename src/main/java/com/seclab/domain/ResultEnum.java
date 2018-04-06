package com.seclab.domain;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/5
 * Time: 11:20
 * Description:
 */
public enum ResultEnum {

    UNKONW_ERROR(-1, "unknown error"),
    SUCCESS(0, "success"),
    LOGIN_FALIURE(100, "login failed"), // 登陆出错
    USER_NOT_FOUND(101, "user not found"); // 用户查找失败

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
