package cn.lhqs.middle.entity;

import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-28 23:47
 * description : Data.class
 * version : 1.0
 */
public class Data {
    private String token ;
    private String name;
    private String avatar;
    private List<Object> roles;

    public Data() {
    }

    public Data(String name, String avatar, List<Object> roles) {
        this.name = name;
        this.avatar = avatar;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Object> getRoles() {
        return roles;
    }

    public void setRoles(List<Object> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Data{" +
                "token='" + token + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roles=" + roles +
                '}';
    }
}
