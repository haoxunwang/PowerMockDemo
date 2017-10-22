package com.nelson.powermock.answer.controller;

import com.nelson.powermock.answer.service.EmployeeService;

public class EmployeeController
{

    public String getEmail(String userName) {
        EmployeeService employeeService = new EmployeeService();
        String email = employeeService.findEmailByUserName(userName);
        return email;
    }
}
