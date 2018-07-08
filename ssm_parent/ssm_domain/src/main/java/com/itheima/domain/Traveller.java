package com.itheima.domain;

public class Traveller {

    private Integer id;
    private String name;
    private String travellerType;
    private String sex;
    private String phoneNum;
    private String credentialsType;
    private String credentialsNum;

    @Override
    public String toString() {
        return "Traveller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", travellerType='" + travellerType + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", credentialsType='" + credentialsType + '\'' +
                ", credentialsNum='" + credentialsNum + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(String travellerType) {
        this.travellerType = travellerType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(String credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }
}
