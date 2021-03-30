package com.xgl.study.springenviroment.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/29
 */
@Data
@PropertySource({"test1.properties" ,"classpath:test1.properties" ,"file:d://test2.properties"})
@Configuration
public class AppConfig {

    @Value("${k1}")
    private String k1;

    @Value("${k2}")
    private String k2;

}
