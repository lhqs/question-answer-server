package cn.lhqs.middle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-29 9:39
 * description : TempController.class
 * version : 1.0
 */

@RestController
@RequestMapping("api")
public class TempController {

    private static Logger logger = LoggerFactory.getLogger(TempController.class);

    @GetMapping("getIp")
    public String getIpAddr(HttpServletRequest request, HttpServletResponse response ){
        String ip = request.getHeader(" x-forwarded-for ");
        System.out.println("ip1:"+ip);
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" Proxy-Client-IP ");
            System.out.println("ip2:"+ip);
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" WL-Proxy-Client-IP ");
            System.out.println("ip3:"+ip);
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            System.out.println("ip4:"+ip);
        }
        logger.info("ip --> "+ ip);
        return ip;
    }

    @GetMapping(value = "/getParamsTest")
    public String getParamTest(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id:"+id;
    }


}
