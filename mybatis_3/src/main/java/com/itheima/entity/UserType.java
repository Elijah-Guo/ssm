package com.itheima.entity;

public class UserType {

    private String id;
    private String name;
    private String jieshao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJieshao() {
        return jieshao;
    }

    public void setJieshao(String jieshao) {
        this.jieshao = jieshao;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jieshao='" + jieshao + '\'' +
                '}';
    }
}
