package com.learning.annotations.Annotations.Aspects;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public String employeeDetails(int id, String name) {
        return ("Employee Details with id: " + id + ", name: " + name + ", fetched");
    }
}
