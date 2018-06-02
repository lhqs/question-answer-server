package cn.lhqs.middle.config;

import cn.lhqs.middle.entity.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ReturnResult defaultException(HttpServletRequest request, Exception exception) {
        logger.error("catch exception :"+exception);
        return ReturnResult.fail;
    }
}
