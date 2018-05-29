package cn.lhqs.middle.controller;

import cn.lhqs.middle.entity.*;
import cn.lhqs.middle.utils.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-29 23:30
 * description : LoginController.class
 * version : 1.0
 */
@RestController
@RequestMapping("api")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @PostMapping("/user/login1")
    public ResponseResult login(@RequestParam("username")String username, @RequestParam("password")String password) {
        logger.info("username -->"+username + ";  password -->"+password);
        if(username.equals("admin")){
            ResponseResult res = new ResponseResult();
            Data data = new Data() ;
            res.setCode(2000);
            res.setData(data);
            return res;
        }
        return null;
    }

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody TempUser user, HttpServletRequest request, HttpServletResponse response) {
        logger.info("username -->"+user.getUsername() + ";  password -->"+user.getPassword());
        // CookieUtils.setCookie(request, response,"test-cookie", "lhqs");
        if(user.getUsername().equals("admin")){
            ResponseResult res = new ResponseResult();
            Data data = new Data() ;
            data.setToken("admin");
            res.setCode(20000);
            res.setData(data);
            return res;
        }
        return null;
    }

    @GetMapping("/user/info")
    public ResponseResult getobject(HttpServletRequest request) {
        Data data = new Data("admin","http://qiniu.lhqs1314.cn/img/user/f8d14c460d4440.jpeg",null);
        ResponseResult res = new ResponseResult(20000,data);
        return res;
    }

    @PostMapping("/user/logout")
    public ResponseObject logout(HttpServletRequest request, HttpServletResponse response ) {
        String user = request.getHeader("x-token");
        // String token = CookieUtils.getCookieValue(request, "test-cookie");  // axios默认是发送请求的时候不会带上cookie的，需要
        // 通过设置withCredentials: true来解决，此时后台Access-Control-Allow-Origin不可以为 '*'，因为 '*' 会和 Access-Control-Allow-Credentials:true 冲突，需配置指定的地址
        logger.info( user + "退出登录");
        return ResponseObject.ok;
    }
}
