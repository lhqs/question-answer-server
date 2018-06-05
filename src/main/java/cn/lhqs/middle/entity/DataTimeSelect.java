package cn.lhqs.middle.entity;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-05 17:32
 * description : DataTimeSelect.class
 * version : 1.0
 */
public class DataTimeSelect {
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "DataTimeSelect{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
