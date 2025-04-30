package com.learning.annotations.Annotations.Hateoas;

import com.learning.annotations.Annotations.Interceptors.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyHateoasTestController {

    @Autowired
    UserService userService;

    @GetMapping("/userDetails")
    public ResponseEntity<UserResponse> getUser(){
        UserResponse response = userService.getUser();
        Link verifyLink = WebMvcLinkBuilder.linkTo(MyHateoasTestController.class)
                .slash("sms-verify-finish")
                .withRel("verify")
                .withType("POST");
        response.addLink(verifyLink);

        Link verifyLink2 = Link.of("/api/sms-verify-finish/") //other way of creating a link
                        .withRel("verify")
                        .withType("POST");
        response.addLink(verifyLink2);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
