package com.xgl.study.springtransaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/24
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long insert(String name ,Integer age ,String email){
        Long userId = System.currentTimeMillis();
        String insertSql = "insert into tb_user_info(id ,name ,age ,email) values(?,?,?,?)";
        jdbcTemplate.update(insertSql, userId, name, age, email);
        return userId;
    }
}
