package cn.lhqs.middle.entity;

import java.util.Date;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-01 16:06
 * description : OperateLog.class
 * version : 1.0
 */

// CREATE TABLE `operate_log` (
//         `log_id` varchar(10) NOT NULL,
//         `user_id` varchar(10) NOT NULL,
//         `ip` varchar(40) DEFAULT NULL,
//         `ip_addr` varchar(255) DEFAULT NULL,
//         `origin` varchar(255) DEFAULT NULL,
//         `click_page` varchar(255) DEFAULT NULL,
//         `operate_content` varchar(255) DEFAULT NULL,
//         `create_time` datetime DEFAULT NULL,
//         `update_time` datetime DEFAULT NULL,
//         PRIMARY KEY (`log_id`)
//         ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

public class OperateLog {
    String logId;
    String userId;
    String ip;
    String ipAddr;
    String origin;
    String clickPage;

    String operateContent;
    Date createTime;
    Date updateTime;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getClickPage() {
        return clickPage;
    }

    public void setClickPage(String clickPage) {
        this.clickPage = clickPage;
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
