package cn.lhqs.middle.service;

import cn.lhqs.middle.entity.DataTimeSelect;
import cn.lhqs.middle.entity.OperateLog;
import cn.lhqs.middle.entity.OperateLogRes;
import cn.lhqs.middle.entity.PageInfo;

import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-01 16:19
 * description : LoggerService.class
 * version : 1.0
 */
public interface LoggerService {

    PageInfo<OperateLogRes> getLogList(int pageNum, int pageSize);
    PageInfo<OperateLogRes> getLogList(int pageNum, int pageSize, String startTime, String endTime);

    int insertLogRecord(OperateLog operateLog);

    int removeLogById(Integer logId);

    List<OperateLogRes> getLogListByTime(DataTimeSelect dataTimeSelect);
    List<OperateLogRes> getLogListByTime(String startTime, String endTime);

}
