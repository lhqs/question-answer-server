package cn.lhqs.middle.service;

import cn.lhqs.middle.entity.User;

import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-30 21:16
 * description : UserService.class
 * version : 1.0
 */
public interface UserService {

    List<User> list();

    List<User> findByUsername(String username);

    User get(String userId);

    int delete(String userId);

}
