package cn.lhqs.middle.entity;

import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-02 16:17
 * description : PageInfo.class
 * version : 1.0
 */
public class PageInfo<T> {

    private Long total;

    private List<T> list;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}