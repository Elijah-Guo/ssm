package com.itheima.entity;

import java.util.Date;

public class QueryVO {
    private String likename;
    private Date strattime;
    private Date endtime;
    private String sex;
    private Integer[] dis;

    public String getLikename() {
        return likename;
    }

    public void setLikename(String likename) {
        this.likename = likename;
    }

    public Date getStrattime() {
        return strattime;
    }

    public void setStrattime(Date strattime) {
        this.strattime = strattime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer[] getDis() {
        return dis;
    }

    public void setDis(Integer[] dis) {
        this.dis = dis;
    }
}
