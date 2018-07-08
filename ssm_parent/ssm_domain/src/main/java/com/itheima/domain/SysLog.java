package com.itheima.domain;

import lombok.Data;

@Data
public class SysLog {

    private Long id;
    private String visitTime;
    private String username;
    private String ip;
    private String method;

}
