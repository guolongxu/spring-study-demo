package com.xgl.study.springtransaction.service;

import com.xgl.study.springtransaction.config.SpringBeanConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/24
 */
public class UserServiceTests {

    private AnnotationConfigApplicationContext applicationContext;


    @Before
    public void setup(){
        applicationContext = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
    }


    @Test
    public void testAdd() throws Exception {
        IUserService userService = applicationContext.getBean(IUserService.class);
        userService.addUser("zhangsan" ,18 ,"888881@qq.com" ,"zhangsan" ,"123456");
    }


    @Test
    public void testAdd2() throws Exception {
        IUserService userService = applicationContext.getBean(IUserService.class);
        userService.addUser2("zhangsan" ,18 ,"888881@qq.com" ,"zhangsan" ,"123456");
    }


    @Test
    public void testAdd3() throws Exception {
        IUserService userService = applicationContext.getBean(IUserService.class);
        userService.addUser3("zhangsan" ,18 ,"888881@qq.com" ,"zhangsan" ,"123456");
    }


    @Test
    public void testAdd4() throws Exception {
        IUserService userService = applicationContext.getBean(IUserService.class);
        userService.addUser4("zhangsan" ,18 ,"888881@qq.com" ,"zhangsan" ,"123456");
    }
}
