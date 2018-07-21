package com.itheima.util;

public class CustomException extends Exception {

    public CustomException(String message) {
        this.message = message;
    }

    //记录错误信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
