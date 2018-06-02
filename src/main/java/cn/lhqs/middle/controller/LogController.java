package cn.lhqs.middle.controller;

import cn.lhqs.middle.entity.OperateLog;
import cn.lhqs.middle.entity.PageInfo;
import cn.lhqs.middle.entity.ReturnResult;
import cn.lhqs.middle.service.LoggerService;
import cn.lhqs.middle.service.UserService;
import cn.lhqs.middle.utils.IpAddrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-29 14:51
 * description : LogController.class
 * version : 1.0
 */
@RestController
@RequestMapping("api")
public class LogController {
    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    @Resource
    LoggerService loggerService;

    @Resource
    UserService userService;

    @PostMapping("/log/setList")
    public ReturnResult setLogList(HttpServletRequest request, @RequestBody OperateLog requestLog/*@RequestParam("clickPage")String clickPage,
                                   @RequestParam("operateContent") String operateContent*/) {
        String token = request.getHeader("X-Token");
        if(!StringUtils.isEmpty(token)){
            int i = userService.updateRequestNums(token);
        }
        OperateLog operateLog = new OperateLog();
        operateLog.setUserId(userService.getUserInfo(token).getUserId());
        operateLog.setIp(IpAddrUtils.getIpAddr(request));
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
    public ReturnResult getLogList(HttpServletRequest request, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "10")int pageSize) {
        // String username = request.getHeader("X-Token");
        logger.info("pageNum:"+pageNum + ";  pageSize:"+pageSize);
        PageInfo<OperateLog> logList = loggerService.getLogList(pageNum, pageSize);
        return new ReturnResult(20000,"success", logList);
    }
}
