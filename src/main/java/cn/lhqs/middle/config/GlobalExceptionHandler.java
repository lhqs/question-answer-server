package cn.lhqs.middle.config;

import cn.lhqs.middle.entity.ResponseResult;
import cn.lhqs.middle.entity.ReturnResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-30 20:45
 * description : GlobalExceptionHandler.class
 * version : 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ReturnResult defaultException(HttpServletRequest request, Exception exception) {
        return ReturnResult.fail;
    }
}
