package com.xgl.study.springtransaction.service.impl;

import com.xgl.study.springtransaction.annotation.XglTransactional;
import com.xgl.study.springtransaction.dao.UserDao;
import com.xgl.study.springtransaction.service.IDegreeService;
import com.xgl.study.springtransaction.service.IUserLoginService;
import com.xgl.study.springtransaction.service.IUserRoleService;
import com.xgl.study.springtransaction.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/24
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private IUserLoginService userLoginService;

    @Autowired
    private IDegreeService degreeService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    //@Transactional(timeout = 5)
    public void addUser(String name, Integer age, String email ,
                        String loginUsername ,String loginPassword) throws Exception {

        Long userId = userDao.insert(name, age, email);
        try{
            userLoginService.addUserLogin(userId ,loginUsername ,loginPassword);
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            userRoleService.addRole(userId ,"admin");
        }catch(Exception e){
            e.printStackTrace();
        }


        //degreeService.addDegree(userId ,"Bachelor" ,"2020-09" ,"2024-06");
    }




    public void addUser2(String name, Integer age, String email ,
                        String loginUsername ,String loginPassword) throws Exception {

        transactionTemplate.executeWithoutResult(transactionStatus -> {
            Long userId = userDao.insert(name, age, email);
            try{
                userLoginService.addUserLogin2(userId ,loginUsername ,loginPassword);
            }catch(Exception e){
                e.printStackTrace();
            }

            try{
               userRoleService.addRole2(userId ,"admin");
            }catch(Exception e){
                e.printStackTrace();
            }
        });

    }



    public void addUser3(String name, Integer age, String email ,
                         String loginUsername ,String loginPassword) throws Exception {
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        try{
            Long userId = userDao.insert(name, age, email);
            try{
                userLoginService.addUserLogin3(userId ,loginUsername ,loginPassword);
            }catch(Exception e){
                e.printStackTrace();
            }

            try{
                userRoleService.addRole3(userId ,"admin");
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(transactionStatus);
            return;
        }

        if(!transactionStatus.isRollbackOnly()){
            platformTransactionManager.commit(transactionStatus);
        }

    }



    @XglTransactional
    public void addUser4(String name, Integer age, String email ,
                         String loginUsername ,String loginPassword) throws Exception {
        Long userId = userDao.insert(name, age, email);
        userLoginService.addUserLogin4(userId ,loginUsername ,loginPassword);

        try{
            userRoleService.addRole4(userId ,"admin");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
