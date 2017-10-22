package com.nelson.powermock.mockfinal.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.mockfinal.dao.EmployeeDao;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void createEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }
}
