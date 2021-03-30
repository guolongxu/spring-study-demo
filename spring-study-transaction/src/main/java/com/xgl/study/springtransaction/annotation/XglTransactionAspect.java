package com.xgl.study.springtransaction.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.lang.reflect.Method;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/26
 */
@Component
@Aspect
public class XglTransactionAspect {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Pointcut("@annotation(com.xgl.study.springtransaction.annotation.XglTransactional)")
    public void transactionPointcut(){}


    @Around("com.xgl.study.springtransaction.annotation.XglTransactionAspect.transactionPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();

        Object target = joinPoint.getTarget();

        XglTransactional xglTransactional = AnnotationUtils.getAnnotation(method, XglTransactional.class);
        if(xglTransactional==null){
            Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
            xglTransactional = AnnotationUtils.getAnnotation(targetMethod, XglTransactional.class);
        }
        if(xglTransactional==null){
            return joinPoint.proceed();
        }

        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        ((DefaultTransactionDefinition) transactionDefinition).setPropagationBehavior(xglTransactional.propagation().value());
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        try{
            Object result = joinPoint.proceed();
            if(!transactionStatus.isRollbackOnly()){
                platformTransactionManager.commit(transactionStatus);
            }
            return result;
        }catch(Exception e){
            platformTransactionManager.rollback(transactionStatus);
            throw new RuntimeException(e);
        }
    }

}
