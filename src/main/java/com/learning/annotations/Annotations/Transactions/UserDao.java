package com.learning.annotations.Annotations.Transactions;

import com.learning.annotations.Annotations.BeanScopes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class UserDao {

    PlatformTransactionManager userTransactionManager;
// uncomment when you want to use programmatic approach 1, for now approach 2 is active
//    UserDao(PlatformTransactionManager userTransactionManager){
//        this.userTransactionManager=userTransactionManager;
//    }

    TransactionTemplate transactionTemplate;

    UserDao(PlatformTransactionManager userTransactionManager,TransactionTemplate transactionTemplate){
        this.userTransactionManager=userTransactionManager;
        this.transactionTemplate=transactionTemplate;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void dbOperationsWithRequiredPropagations(){
        System.out.println("Is actual transaction active: "+ TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Get actual transaction name: "+TransactionSynchronizationManager.getCurrentTransactionName());
    }

    public void dbOperationsWithRequiredPropagationsProgrammaticApproach1(){
        DefaultTransactionDefinition transactionDefinition=new DefaultTransactionDefinition();
        transactionDefinition.setName("dbOperationsWithRequiredPropagationsProgrammaticApproach1");
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = userTransactionManager.getTransaction(transactionDefinition);
        try{
            System.out.println("Is actual transaction active: "+ TransactionSynchronizationManager.isActualTransactionActive());
            System.out.println("Get actual transaction name: "+TransactionSynchronizationManager.getCurrentTransactionName());
            userTransactionManager.commit(status);
        } catch (Exception e){
            userTransactionManager.rollback(status);
        }
    }

    public void dbOperationsWithRequiredPropagationsProgrammaticApproach2(){
        TransactionCallback<TransactionStatus> operations = (TransactionStatus status)->{
            System.out.println("Is actual transaction active: "+ TransactionSynchronizationManager.isActualTransactionActive());
            System.out.println("Get actual transaction name: "+TransactionSynchronizationManager.getCurrentTransactionName());
            return status;
        };
        TransactionStatus status = transactionTemplate.execute(operations);
    }
}
