package com.nelson.powermock.helloworld.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.helloworld.dao.EmployeeDao;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int getTotalEmployee() {
        return employeeDao.getTotal();
    }

    public void createEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }
}
