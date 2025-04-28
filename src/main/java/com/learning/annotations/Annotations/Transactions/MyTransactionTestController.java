package com.learning.annotations.Annotations.Transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyTransactionTestController {

    @Autowired
    UserService userService;

    @GetMapping("/userDetails")
    public void updateUserDeclaredTransactional(){
        userService.updateUserDeclaredTransactional();
    }

    @GetMapping("/updateDetailsNotDeclared")
    public void updateUserDeclaredNonTransactional(){
        userService.updateUserDeclaredNonTransactional();
    }

    @GetMapping("/updateUserProgrammaticWayTransactional")
    public void updateUserProgrammaticWayTransactional(){
        userService.updateUserProgrammaticWayTransactional();
    }

    @GetMapping("/updateUserProgrammaticWayNonTransactional")
    public void updateUserProgrammaticWayNonTransactional(){
        userService.updateUserProgrammaticWayNonTransactional();
    }

    @GetMapping("/updateUserProgrammaticWayTransactionalApproach2")
    public void updateUserProgrammaticWayTransactionalApproach2(){
        userService.updateUserProgrammaticWayTransactionalApproach2();
    }

    @GetMapping("/updateUserProgrammaticWayNonTransactionalApproach2")
    public void updateUserProgrammaticWayNonTransactionalApproach2(){
        System.out.println("came in here");
        userService.updateUserProgrammaticWayNonTransactionalApproach2();
    }

}
