package cn.lhqs.middle.service;

import cn.lhqs.middle.entity.UserInfo;

import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-30 21:16
 * description : UserService.class
 * version : 1.0
 */
public interface UserService {

    // List<UserInfo> list();
    //
    // List<UserInfo> findByUsername(String username);
    //
    // UserInfo get(String userId);
    //
    // int delete(String userId);

    int loginTest(String username, String password);

    UserInfo getUserInfo(String token);

    int updateRequestNums(String token);


}
