package cn.lhqs.middle.entity;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-28 23:46
 * description : ResponseResult.class
 * version : 1.0
 */
public class ResponseResult {
    private int code;
    private Data data;

    public ResponseResult() {
    }

    public ResponseResult(int code, Data data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
