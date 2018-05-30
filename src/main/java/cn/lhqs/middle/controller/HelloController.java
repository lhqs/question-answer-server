package cn.lhqs.middle.controller;

import cn.lhqs.middle.entity.User;
import cn.lhqs.middle.service.UserService;
import cn.lhqs.middle.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    UserService userServiceImpl;

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

    @GetMapping("getList")
    public List getList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("one");
        list.add("two");
        list.add("three");
        return list;
    }

    @GetMapping("getListobj")
    public List getListObj() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setUsername("lhqs");
        user.setAge(34);
        User user2 = new User();
        user2.setUsername("lhqs");
        user2.setAge(34);

        list.add(user);
        list.add(user2);

        return list;
    }

    @GetMapping("getMap")
    public Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        return map ;
    }

    @GetMapping("getEx")
    public Map<Integer, String> getEx() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        throw new RuntimeException("nini ");
    }

    @GetMapping("getUserList")
    public List getUserList() {
        return userServiceImpl.list();
    }
}
