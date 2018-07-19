package com.itheima.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setUsername(resultSet.getString("a_name"));
        account.setMoney(resultSet.getDouble("a_money"));
        account.setId(resultSet.getInt("a_id"));
        return account;
    }
}
