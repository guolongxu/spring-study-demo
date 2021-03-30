package com.xgl.study.springenviroment.annotation;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.*;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/29
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE ,ElementType.METHOD})
@Profile("prod")
public @interface Production {
}
