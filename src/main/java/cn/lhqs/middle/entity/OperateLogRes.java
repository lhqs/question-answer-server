package cn.lhqs.middle.entity;

import java.util.Date;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-05 13:29
 * description : OperateLogRes.class
 * version : 1.0
 */
public class OperateLogRes {
    String logId;
    String userId;
    String ip;
    String ipAddr;
    String origin;
    String clickPage;

    String operateContent;
    Date createTime;
    Date updateTime;
    String username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "OperateLogRes{" +
                "logId='" + logId + '\'' +
                ", userId='" + userId + '\'' +
                ", ip='" + ip + '\'' +
                ", ipAddr='" + ipAddr + '\'' +
                ", origin='" + origin + '\'' +
                ", clickPage='" + clickPage + '\'' +
                ", operateContent='" + operateContent + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", username='" + username + '\'' +
                '}';
    }
}
