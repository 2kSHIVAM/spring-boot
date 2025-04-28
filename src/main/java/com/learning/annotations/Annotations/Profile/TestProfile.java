package com.learning.annotations.Annotations.Profile;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev") // due to this bean will only be created when the active profile be dev
public class TestProfile {

    @Value("${db.url}")
    String dbUrl;

    @PostConstruct
    public void init(){
        System.out.println("Db url is: "+dbUrl);
    }
}
