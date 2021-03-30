package com.xgl.study.springtransaction.service.impl;

import com.xgl.study.springtransaction.annotation.XglTransactional;
import com.xgl.study.springtransaction.dao.UserRoleDao;
import com.xgl.study.springtransaction.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/24
 */
@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Transactional(propagation = Propagation.NESTED)
    public void addRole(Long userId, String role) {
        userRoleDao.insert(userId ,role);
        throw new RuntimeException("test ... exception");
    }

    public void addRole2(Long userId, String role) {
        userRoleDao.insert(userId ,role);
    }

    public void addRole3(Long userId, String role) {
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        try{
            userRoleDao.insert(userId ,role);
            if(userId>1){
                throw new RuntimeException("test ... exception");
            }
        }catch(Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(transactionStatus);
            throw new RuntimeException(e);
        }

        platformTransactionManager.commit(transactionStatus);
    }



    @XglTransactional(propagation = Propagation.REQUIRES_NEW)
    public void addRole4(Long userId, String role) {
        userRoleDao.insert(userId ,role);
        if(userId>1){
            throw new RuntimeException("test ... exception");
        }
    }
}
