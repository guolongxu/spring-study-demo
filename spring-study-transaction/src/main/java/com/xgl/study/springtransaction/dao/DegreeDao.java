package com.xgl.study.springtransaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/24
 */
@Repository
public class DegreeDao {

    @Qualifier("jdbcTemplate2")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long insert(Long userId ,String degree , Date startTime , Date endTime){
        Long id = System.currentTimeMillis();
        String insertSql = "insert into tb_degree(id ,user_id ,degree ,start_time ,end_time) values(?,?,?,?,?)";
        jdbcTemplate.update(insertSql, id, userId ,degree, startTime, endTime);
        return id;
    }

}
