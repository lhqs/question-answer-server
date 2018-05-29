package cn.lhqs.middle.controller;

import cn.lhqs.middle.entity.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-29 14:51
 * description : LogController.class
 * version : 1.0
 */
@RestController
@RequestMapping("api")
public class LogController {
    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log/setList")
    public ReturnResult setLogList(HttpServletRequest request) {
        String username = request.getHeader("x-token");


        return ReturnResult.ok;
    }

    @GetMapping("/log/getList")
    public ReturnResult getLogList(HttpServletRequest request) {
        String username = request.getHeader("x-token");
        ReturnResult result = new ReturnResult();



        return result;
    }
}
