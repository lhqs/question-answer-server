package cn.lhqs.middle.entity;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-28 23:56
 * description : TempUser.class
 * version : 1.0
 */
public class TempUser {
    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "TempUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
