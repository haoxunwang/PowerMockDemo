package com.nelson.powermock.matcher.controller;

import com.nelson.powermock.matcher.service.EmployeeService;

public class EmployeeController {

    public String getEmail(String userName) {
        EmployeeService employeeService = new EmployeeService();
        String email = employeeService.findEmailByUserName(userName);
        return email;
    }
}
