package cn.lhqs.middle.serviceImpl;

import cn.lhqs.middle.entity.DataTimeSelect;
import cn.lhqs.middle.entity.OperateLog;
import cn.lhqs.middle.entity.OperateLogRes;
import cn.lhqs.middle.entity.PageInfo;
import cn.lhqs.middle.mapper.LoggerMapper;
import cn.lhqs.middle.service.LoggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-01 16:20
 * description : LoggerServiceImpl.class
 * version : 1.0
 */
@Service
public class LoggerServiceImpl implements LoggerService{

    @SuppressWarnings("all")
    @Resource
    LoggerMapper loggerMapper;

    @Override
    public PageInfo<OperateLogRes> getLogList(int pageNum, int pageSize) {
        // PageInfo<OperateLog> pageInfo = new PageInfo<>();
        // Page<OperateLog> page = PageHelper.startPage(pageNum, pageSize);
        // List<OperateLog> allOperatorLogList = loggerMapper.getOperateLogList();
        // pageInfo.setTotal(page.getTotal());
        // pageInfo.setList(allOperatorLogList);
        int realPageNum = ( pageNum - 1) * pageSize;
        PageInfo<OperateLogRes> pageInfo = new PageInfo<>();
        List<OperateLogRes> operateLogList = loggerMapper.getOperateLogList(realPageNum, pageSize);
        pageInfo.setTotal(loggerMapper.total());
        pageInfo.setList(operateLogList);
        return pageInfo;
    }

    @Override
    public PageInfo<OperateLogRes> getLogList(int pageNum, int pageSize, String startTime, String endTime) {
        int realPageNum = ( pageNum - 1) * pageSize;
        PageInfo<OperateLogRes> pageInfo = new PageInfo<>();
        List<OperateLogRes> operateLogList = loggerMapper.getLogList(startTime,endTime,realPageNum, pageSize);
        pageInfo.setTotal(loggerMapper.totalTime(startTime,endTime));
        pageInfo.setList(operateLogList);
        return pageInfo;
    }

    @Override
    public int insertLogRecord(OperateLog operateLog) {
        return loggerMapper.insertLog(operateLog);
    }

    @Override
    public int removeLogById(Integer logId) {

        return loggerMapper.removeLogById(logId);
    }

    @Override
    public List<OperateLogRes> getLogListByTime(DataTimeSelect dataTimeSelect) {
        List<OperateLogRes> logList = loggerMapper.getLogByTime(dataTimeSelect.getStartTime(), dataTimeSelect.getEndTime());
        return logList;
    }

    @Override
    public List<OperateLogRes> getLogListByTime(String startTime, String endTime) {
        List<OperateLogRes> logList = loggerMapper.getLogByTime(startTime, endTime);
        return logList;
    }
}
