package com.xgl.study.springtransaction.service.impl;

import com.xgl.study.springtransaction.annotation.XglTransactional;
import com.xgl.study.springtransaction.dao.UserLoginDao;
import com.xgl.study.springtransaction.service.IUserLoginService;
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
public class UserLoginServiceImpl implements IUserLoginService {

    @Autowired
    private UserLoginDao userLoginDao;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Transactional(propagation = Propagation.NESTED)
    public void addUserLogin(Long userId, String username, String password) {
        /*try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        userLoginDao.insert(userId ,username ,password);

        //throw new RuntimeException("test ... exception");
    }


    public void addUserLogin2(Long userId, String username, String password) {
        userLoginDao.insert(userId ,username ,password);
    }

    public void addUserLogin3(Long userId, String username, String password) {
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        try{
            userLoginDao.insert(userId ,username ,password);
        }catch(Exception e){
            e.printStackTrace();
            platformTransactionManager.rollback(transactionStatus);
            throw new RuntimeException(e);
        }

        platformTransactionManager.commit(transactionStatus);
    }


    @XglTransactional
    public void addUserLogin4(Long userId, String username, String password) {
        userLoginDao.insert(userId ,username ,password);
    }
}
