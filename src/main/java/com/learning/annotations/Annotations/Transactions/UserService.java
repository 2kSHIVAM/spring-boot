package com.learning.annotations.Annotations.Transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public void updateUserDeclaredTransactional(){
        System.out.println("Is actual transaction active: "+ TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Get actual transaction name: "+TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Some initial db operations");
        userDao.dbOperationsWithRequiredPropagations();
        System.out.println("Some final db operations");
    }

    public void updateUserDeclaredNonTransactional(){
        System.out.println("Is actual transaction active: "+ TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Get actual transaction name: "+TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Some initial db operations");
        userDao.dbOperationsWithRequiredPropagations();
        System.out.println("Some final db operations");
    }

    @Transactional
    public void updateUserProgrammaticWayTransactional(){
        System.out.println("Is actual transaction active: "+ TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Get actual transaction name: "+TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Some initial db operations");
        userDao.dbOperationsWithRequiredPropagationsProgrammaticApproach1();
        System.out.println("Some final db operations");
    }

    public void updateUserProgrammaticWayNonTransactional(){
        System.out.println("Is actual transaction active: "+ TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Get actual transaction name: "+TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Some initial db operations");
        userDao.dbOperationsWithRequiredPropagationsProgrammaticApproach1();
        System.out.println("Some final db operations");
    }

    @Transactional
    public void updateUserProgrammaticWayTransactionalApproach2(){
        System.out.println("Is actual transaction active: "+ TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Get actual transaction name: "+TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Some initial db operations");
        userDao.dbOperationsWithRequiredPropagationsProgrammaticApproach2();
        System.out.println("Some final db operations");
    }

    public void updateUserProgrammaticWayNonTransactionalApproach2(){
        System.out.println("Is actual transaction active: "+ TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Get actual transaction name: "+TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Some initial db operations");
        userDao.dbOperationsWithRequiredPropagationsProgrammaticApproach2();
        System.out.println("Some final db operations");
    }

}
