package com.itheima.dao;

import com.itheima.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface SysLogDao {

    @Insert("insert into sys_log (visitTime,username,ip,method) values (#{visitTime},#{username},#{ip},#{method})")
    void save(SysLog sysLog);
}
