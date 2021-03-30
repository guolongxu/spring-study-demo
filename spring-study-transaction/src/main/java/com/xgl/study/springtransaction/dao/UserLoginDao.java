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
public class UserLoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Long userId ,String username ,String password){
        Long id = System.currentTimeMillis() + System.currentTimeMillis();
        String insertSql = "insert into tb_user_login(id ,user_id ,username ,password) values(?,?,?,?)";
        jdbcTemplate.update(insertSql, id, userId, username, password);
    }
}
