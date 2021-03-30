package com.xgl.study.springtransaction.service;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/24
 */
public interface IUserService {

    void addUser(String name ,Integer age ,String email ,String loginUsername ,String loginPassword) throws Exception;
    void addUser2(String name ,Integer age ,String email ,String loginUsername ,String loginPassword) throws Exception;
    void addUser3(String name ,Integer age ,String email ,String loginUsername ,String loginPassword) throws Exception;
    void addUser4(String name ,Integer age ,String email ,String loginUsername ,String loginPassword) throws Exception;

}
