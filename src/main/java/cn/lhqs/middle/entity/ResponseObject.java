package cn.lhqs.middle.entity;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-29 12:58
 * description : ResponseObject.class
 * version : 1.0
 */
public class ResponseObject {
    public int code;
    public String data;

    public ResponseObject(int code, String data){
        this.code = code;
        this.data = data;
    }

    public ResponseObject() {
    }

    public static ResponseObject ok = new ResponseObject(20000, "success");

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "code=" + code +
                ", data='" + data + '\'' +
                '}';
    }
}
