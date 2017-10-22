package com.nelson.powermock.local.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.local.dao.EmployeeDao;

public class EmployeeService {

    public int getTotalEmployee() {
        EmployeeDao employeeDao = new EmployeeDao();
        return employeeDao.getTotal();
    }

    public void createEmployee(Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.addEmployee(employee);
    }
}
