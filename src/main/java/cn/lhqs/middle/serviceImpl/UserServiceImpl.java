package cn.lhqs.middle.serviceImpl;

import cn.lhqs.middle.entity.User;
import cn.lhqs.middle.mapper.UserMapper;
import cn.lhqs.middle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-30 21:17
 * description : UserServiceImpl.class
 * version : 1.0
 */
@Service
public class UserServiceImpl  implements UserService {

    @SuppressWarnings("all")
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public List<User> findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User get(String userId) {
        return userMapper.getOne(userId);
    }

    @Override
    public int delete(String userId) {
        return userMapper.delete(userId);
    }
}