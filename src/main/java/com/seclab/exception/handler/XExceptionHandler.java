package com.seclab.exception.handler;

import com.seclab.domain.Result;
import com.seclab.exception.LoginException;
import com.seclab.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/5
 * Time: 11:14
 * Description: 异常捕捉并处理中心，所有的Exception最终都会到这里走一趟(*.*)
 */
@ControllerAdvice
public class XExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(XExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof LoginException) {
            LoginException loginException = (LoginException) e;
            return ResultUtil.error(loginException.getCode(), loginException.getMessage());
        } else {
            logger.error("Unknown error occurred: {}", e);
            return ResultUtil.error(-1, "Unknown error.");
        }
    }
}
