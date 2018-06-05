package cn.lhqs.middle.mapper;

import cn.lhqs.middle.entity.DataTimeSelect;
import cn.lhqs.middle.entity.OperateLog;
import cn.lhqs.middle.entity.OperateLogRes;
import org.apache.ibatis.annotations.*;

import javax.print.attribute.DateTimeSyntax;
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

    @Select({"<script>",
            "SELECT count(*) from operate_log",
            "WHERE 1=1 ",
            "<when test='endTime!=\"\"'>",
            " AND  create_time <![CDATA[ <= ]]> #{endTime}",
            "</when>",
            "<when test='startTime!=\"\"'>",
            " AND create_time <![CDATA[ >= ]]> #{startTime}",
            "</when>",
            "</script>"})
    long totalTime(@Param("startTime")String startTime, @Param("endTime")String endTime);


    // @Select("select * from operate_log limit  #{pageNum}, #{pageSize}")
    /*@Results({
            @Result(property = "logId", column = "log_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "clickPage", column = "click_page"),
            @Result(property = "operateContent", column = "operate_content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
    })*/
    @Select("SELECT\n" +
            "\tu.username,\n" +
            "\tl.user_id AS userId,\n" +
            "\tl.log_id AS logId,\n" +
            "\tl.ip,\n" +
            "\tl.ip_addr,\n" +
            "\tl.click_page,\n" +
            "\tl.operate_content,\n" +
            "\tl.origin,\n" +
            "\tl.create_time,\n" +
            "\tl.update_time\n" +
            "FROM\n" +
            "\toperate_log AS l,\n" +
            "\tuser_info AS u\n" +
            "WHERE\n" +
            "\tl.user_id = u.user_id" +
            " order by l.create_time desc limit  #{pageNum}, #{pageSize} ")
    List<OperateLogRes> getOperateLogList(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    @Options(useGeneratedKeys = true, keyProperty = "log_id")
    @Insert("insert into operate_log( user_id,ip, ip_addr, origin, click_page,operate_content, create_time, update_time) values(#{userId},#{ip},#{ipAddr}, #{origin}, #{clickPage}, #{operateContent}, #{createTime}, #{updateTime})")
    int insertLog(OperateLog operateLog);

    @Delete("delete from operate_log where log_id = #{logId}")
    int removeLogById(@Param("logId") int logId);

    @Select("SELECT u.username, l.user_id AS userId, l.log_id AS logId, l.ip, l.ip_addr,\n" +
            "\tl.click_page, l.operate_content, l.origin, l.create_time, l.update_time\n" +
            "FROM\n" +
            "\toperate_log AS l, user_info AS u\n" +
            "WHERE\n" +
            "\tl.user_id = u.user_id AND l.create_time <= #{endTime} AND l.create_time >= #{startTime}\n" +
            "ORDER BY create_time DESC")
    List<OperateLogRes> getLogByTime(@Param("startTime")String startTime, @Param("endTime")String endTime);

    // @Select({"<script>",
    //         "SELECT * FROM operate_log",
    //         "WHERE 1=1",
    //         "<when test='startTime!=null'>",
    //         "AND create_time = #{startTime}",
    //         "</when>",
    //         "</script>"})
    @Select({"<script>",
            "SELECT u.username, l.user_id AS userId, l.log_id AS logId, l.ip, l.ip_addr,l.click_page, l.operate_content, l.origin, l.create_time, l.update_time ",
            "FROM operate_log AS l, user_info AS u",
            "WHERE l.user_id = u.user_id ",
            "<when test='endTime!=\"\"'>",
            " AND l.create_time <![CDATA[ <= ]]> #{endTime}",
            "</when>",
            "<when test='startTime!=\"\"'>",
            " AND l.create_time <![CDATA[ >= ]]> #{startTime}",
            "</when>",
            " ORDER BY create_time DESC  limit  #{pageNum}, #{pageSize} ",
            "</script>"})
    List<OperateLogRes> getLogList(@Param("startTime")String startTime, @Param("endTime")String endTime,@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

}
