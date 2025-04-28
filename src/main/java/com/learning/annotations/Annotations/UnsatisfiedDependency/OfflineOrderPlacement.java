package com.learning.annotations.Annotations.UnsatisfiedDependency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("offlineOrderPlacement")
public class OfflineOrderPlacement extends OrderPlacement {
    OfflineOrderPlacement() {
        System.out.println("This is offline order placement");
    }
}
