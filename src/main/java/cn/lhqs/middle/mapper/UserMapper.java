package cn.lhqs.middle.mapper;

import cn.lhqs.middle.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-30 21:11
 * description : mapper.class
 * version : 1.0
 */
@Mapper
public interface UserMapper {

    // @Select("select * from t_user where 1=1")
    // List<UserInfo> list();
    //
    // @Select("select * from t_user where username like #{username}")
    // List<UserInfo> findByUsername(String username);
    //
    // @Select("select * from t_user where user_id like #{userId}")
    // UserInfo getOne(String userId);
    //
    // @Delete("delete from t_user where user_id like #{userId}")
    // int delete(String userId);

    @Select(" select count(*) from user_info where username= #{username} and password = #{password}")
    int loginTest(@Param("username") String username, @Param("password")String password );

    @Select("select * from user_info where token = #{token}")
    UserInfo getUserInfo(@Param("token") String token);

    @Update("update user_info set request_nums = request_nums - 1  where token = #{token}")
    int updateRequestNums(@Param("token") String token);

}
