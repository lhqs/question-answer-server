package cn.lhqs.middle.controller;

import cn.lhqs.middle.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-26 9:40
 * description : HelloController.class
 * version : 1.0
 */

@RestController
@RequestMapping("api")

public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    // @CrossOrigin(origins = "http://localhost:8090")
    public String getStr() {
        // System.out.println("============boot===============");
        logger.info("==========boot==========");
        return "boot is start";
    }

    @GetMapping("/obj")
    // @CrossOrigin("http://localhost:8099")
    public User getObj() {
        User user = new User();
        user.setAge(23);
        user.setSex("男");
        user.setUsername("lhqs");
        logger.info("user ----> "+ user);
        return user;
    }
}
