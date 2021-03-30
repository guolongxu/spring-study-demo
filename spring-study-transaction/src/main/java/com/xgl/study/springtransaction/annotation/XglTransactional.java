package com.xgl.study.springtransaction.annotation;

import org.springframework.transaction.annotation.Propagation;

import java.lang.annotation.*;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/26
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface XglTransactional {
    Propagation propagation() default Propagation.REQUIRED;
}
