package cn.lhqs.middle.mapper;

import cn.lhqs.middle.entity.OperateLog;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-01 16:05
 * description : LoggerMapper.class
 * version : 1.0
 */
@Mapper
public interface LoggerMapper {

    @Select("select count(*) from operate_log")
    long total();

    @Select("select * from operate_log limit  #{pageNum}, #{pageSize}")
    /*@Results({
            @Result(property = "logId", column = "log_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "clickPage", column = "click_page"),
            @Result(property = "operateContent", column = "operate_content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })*/
    List<OperateLog> getOperateLogList(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    @Options(useGeneratedKeys = true, keyProperty = "log_id")
    @Insert("insert into operate_log( user_id,ip, ip_addr, origin, click_page,operate_content, create_time, update_time) values(#{userId},#{ip},#{ipAddr}, #{origin}, #{clickPage}, #{operateContent}, #{createTime}, #{updateTime})")
    int insertLog(OperateLog operateLog);
}
