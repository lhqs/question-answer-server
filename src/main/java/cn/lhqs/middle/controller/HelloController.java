package cn.lhqs.middle.controller;

import cn.lhqs.middle.entity.UserInfo;
import cn.lhqs.middle.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
    public UserInfo getObj() {
        UserInfo userInfo = new UserInfo();
        userInfo.setSex(1);
        userInfo.setUsername("lhqs");
        logger.info("userInfo ----> " + userInfo);
        return userInfo;
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
        List<UserInfo> list = new ArrayList<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("lhqs");
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUsername("lhqs");

        list.add(userInfo);
        list.add(userInfo2);

        return list;
    }

    @GetMapping("getMap")
    public Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        return map;
    }

    @GetMapping("getEx")
    public Map<Integer, String> getEx() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        throw new RuntimeException("nini ");
    }

    @GetMapping("/testget")
    public String testget(@RequestParam("one") String one) {
        System.out.println(one);
        return one;
    }

    @PostMapping("/testpost")
    public String testpost(@RequestParam("one") String one) {
        System.out.println(one);
        return one;
    }
}

