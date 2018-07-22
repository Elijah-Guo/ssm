package com.itheima.util;

/**
 * 自定义的异常类
 */
public class CustomException extends Exception {

    // 有参构造
    public CustomException(String message) {
        this.message = message;
    }

    // 记录错误信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
