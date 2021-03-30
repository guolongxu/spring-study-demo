package com.xgl.study.springtransaction.config;

import com.mysql.cj.jdbc.Driver;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/24
 */
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(basePackages = "com.xgl.study.springtransaction")
@Configuration
public class SpringBeanConfig {

    @Bean
    public DataSource dataSource1(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://172.17.38.109:3306/test1?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUsername("root");
        dataSource.setPassword("db_admin#ops.fm");

        return dataSource;
    }

    @Bean
    public DataSource dataSource2(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://172.17.38.109:3306/test2?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUsername("root");
        dataSource.setPassword("db_admin#ops.fm");

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager transactionManager1(DataSource dataSource1){
        return new DataSourceTransactionManager(dataSource1);
    }
    @Bean
    public PlatformTransactionManager transactionManager2(DataSource dataSource2){
        return new DataSourceTransactionManager(dataSource2);
    }


    @Primary
    @Bean
    public JdbcTemplate jdbcTemplate1(DataSource dataSource1){
        return new JdbcTemplate(dataSource1);
    }


    @Bean
    public JdbcTemplate jdbcTemplate2(DataSource dataSource2){
        return new JdbcTemplate(dataSource2);
    }


    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager){
        return new TransactionTemplate(transactionManager);
    }


}
