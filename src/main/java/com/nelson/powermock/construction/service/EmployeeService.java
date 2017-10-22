package com.nelson.powermock.construction.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.construction.dao.EmployeeDao;

public class EmployeeService {

    public void createEmployee(Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao(false, EmployeeDao.Dialect.MYSQL);
        employeeDao.insertEmployee(employee);

    }
}
