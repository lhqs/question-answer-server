package cn.lhqs.middle.entity;

import java.util.Date;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-27 11:07
 * description : UserInfo.class
 * version : 1.0
 */

//         `user_id` int(10) NOT NULL AUTO_INCREMENT,
//         `token` varchar(255) DEFAULT NULL,
//         `username` varchar(255) DEFAULT NULL,
//         `password` varchar(255) DEFAULT NULL,
//         `email` varchar(255) DEFAULT NULL,
//         `mobile_phone` varchar(255) DEFAULT NULL,
//         `request_nums` int(6) DEFAULT NULL,
//         `status` int(1) DEFAULT '1',
//         `sex` int(1) DEFAULT '0',
//         `avatar` varchar(255) DEFAULT NULL,
//         `create_time` datetime DEFAULT NULL,
//         `update_time` datetime DEFAULT NULL,
public class UserInfo {
    private String userId;
    private String token;
    private String username;
    private String password;
    private String email;
    private String mobilePhone;
    private int requestNum;
    private int status;
    private int sex;
    private String avatar;
    private Date createTime;
    private Date updateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(int requestNum) {
        this.requestNum = requestNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
