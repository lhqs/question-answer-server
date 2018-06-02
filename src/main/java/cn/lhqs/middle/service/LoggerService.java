package cn.lhqs.middle.service;

import cn.lhqs.middle.entity.OperateLog;
import cn.lhqs.middle.entity.PageInfo;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-01 16:19
 * description : LoggerService.class
 * version : 1.0
 */
public interface LoggerService {

    PageInfo<OperateLog> getLogList(int pageNum, int pageSize);

    int insertLogRecord(OperateLog operateLog);
}
