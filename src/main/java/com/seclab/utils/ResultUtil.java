package com.seclab.utils;

import com.seclab.domain.Result;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/5
 * Time: 11:06
 * Description:
 */
public class ResultUtil {

    /**
     * 请求成功返回成功的结果，并包含返回的数据
     *
     * @param data
     * @return
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    /**
     * 请求成功返回成功的结果，但是没有数据
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 请求你失败返回结果
     *
     * @param code    代码
     * @param message 失败信息
     * @return
     */
    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
