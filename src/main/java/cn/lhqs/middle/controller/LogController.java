package cn.lhqs.middle.controller;

import cn.lhqs.middle.entity.*;
import cn.lhqs.middle.service.ExportService;
import cn.lhqs.middle.service.LoggerService;
import cn.lhqs.middle.service.UserService;
import cn.lhqs.middle.utils.IpAddrUtils;
import cn.lhqs.middle.utils.TimeTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-29 14:51
 * description : LogController.class
 * version : 1.0
 */
@Controller
@RequestMapping("api")
public class LogController {
    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    @Resource
    LoggerService loggerService;

    @Resource
    UserService userService;

    @Resource
    ExportService exportService;

    @PostMapping("/log/setList")
    @ResponseBody
    public ReturnResult setLogList(HttpServletRequest request, @RequestBody OperateLog requestLog/*@RequestParam("clickPage")String clickPage,
                                   @RequestParam("operateContent") String operateContent*/) {
        String token = request.getHeader("X-Token");
        if(!StringUtils.isEmpty(token)){
            int i = userService.updateRequestNums(token);
        }
        String ip = IpAddrUtils.getIpAddr(request);
        OperateLog operateLog = new OperateLog();
        operateLog.setUserId(userService.getUserInfo(token).getUserId());
        operateLog.setIp(ip);
        operateLog.setIpAddr(IpAddrUtils.getAddressByIP(ip));
        operateLog.setOrigin(request.getHeader("User-Agent"));
        operateLog.setClickPage(requestLog.getClickPage());
        operateLog.setOperateContent(requestLog.getOperateContent());
        operateLog.setCreateTime(new Date());
        operateLog.setUpdateTime(new Date());
        int logId = loggerService.insertLogRecord(operateLog);
        logger.info("the return logId is "+logId);

        return ReturnResult.ok;
    }

    @GetMapping("/log/getList")
    @ResponseBody
    public ReturnResult getLogList(HttpServletRequest request, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "10")int pageSize) {
        // String username = request.getHeader("X-Token");
        logger.info("pageNum:"+pageNum + ";  pageSize:"+pageSize);
        PageInfo<OperateLogRes> logList = loggerService.getLogList(pageNum, pageSize);
        return new ReturnResult(20000,"success", logList);
    }

    @GetMapping("/log/getLogList")
    @ResponseBody
    public ReturnResult getLogList(HttpServletRequest request, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "10")int pageSize,
                                   @RequestParam("startTime") String startTime,
                                   @RequestParam("endTime")String endTime) {
        // String username = request.getHeader("X-Token");
        if(endTime == null) {
            System.out.println("endtime is null");
        }
        if(endTime == ""){
            System.out.println("endtime is Blank");
        }
        logger.info("pageNum:"+pageNum + ";  pageSize:"+pageSize  + "; startTime:"+startTime+ "; endTime:"+ endTime);
        PageInfo<OperateLogRes> logList = loggerService.getLogList(pageNum, pageSize,startTime, endTime);
        return new ReturnResult(20000,"success", logList);
    }

    @DeleteMapping("/log/deleteLogById")
    @ResponseBody
    public ReturnResult deleteLogById(@RequestParam("logId") Integer logId ) {
        int removeRes = loggerService.removeLogById(logId);
        logger.info("delete_log res ---> " + removeRes);
        return ReturnResult.ok;
    }

    @GetMapping(value = "/log/exportLogByTime1")
    public ReturnResult exportLogByTime1(/*@RequestBody  DataTimeSelect dataTimeSelect*/ @RequestParam("startTime") String startTime,
                                        @RequestParam("endTime")String endTime, HttpServletResponse response){
        logger.info("startTime : "+startTime);
        logger.info("endTime : "+endTime);
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=user-operate-log("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        try {
            exportService.exportExcelForLog(startTime,endTime,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            return ReturnResult.fail;
        }
        return ReturnResult.ok;
    }

    @GetMapping(value = "/log/exportLogByTime")
    public ReturnResult exportLogByTime( DataTimeSelect dataTimeSelect , HttpServletResponse response){
        logger.info("dataTimeSelect : "+dataTimeSelect);
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=user-operate-log("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE1)+").xlsx");
        try {
            // exportService.exportExcelForLog(startTime,endTime,response.getOutputStream());
            exportService.exportExcelForLog(dataTimeSelect, response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            return ReturnResult.fail;
        }
        return ReturnResult.ok;
    }
}
