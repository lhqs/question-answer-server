package cn.lhqs.middle.controller;

import cn.lhqs.middle.entity.*;
import cn.lhqs.middle.service.UserService;
import cn.lhqs.middle.utils.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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

    @Resource
    UserService userService;

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    /*@PostMapping("/user/login1")
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
    }*/

    @PostMapping("/user/login")
    public ReturnResult login(@RequestBody TempUser user, HttpServletRequest request, HttpServletResponse response) {
        logger.info("username -->"+user.getUsername() + ";  password -->"+user.getPassword());
        int respCode = userService.loginTest(user.getUsername(), user.getPassword());
        Map<String, String> map = new HashMap<>();
        map.put("token", user.getUsername());
        if (respCode == 1){
            return new ReturnResult(20000,"success",map);
        }
        return new ReturnResult(-2,"fail","登录验证不通过");
    }

    @GetMapping("/user/info")
    public ReturnResult getobject(HttpServletRequest request) {
        String token = request.getHeader("X-Token");
        logger.info(" getInfo token --->" + token);
        UserInfo userInfo = userService.getUserInfo(token);
        return new ReturnResult(20000,"success",userInfo);
    }

    @PostMapping("/user/logout")
    public ReturnResult logout(HttpServletRequest request, HttpServletResponse response ) {
        String user = request.getHeader("X-Token");
        // String token = CookieUtils.getCookieValue(request, "test-cookie");  // axios默认是发送请求的时候不会带上cookie的，需要
        // 通过设置withCredentials: true来解决，此时后台Access-Control-Allow-Origin不可以为 '*'，因为 '*' 会和 Access-Control-Allow-Credentials:true 冲突，需配置指定的地址
        logger.info( user + "退出登录");
        // return ResponseObject.ok;
        return new ReturnResult(20000,"success","succes");
    }
}
