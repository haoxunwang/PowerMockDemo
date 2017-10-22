package com.nelson.powermock.mockstatic.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.mockstatic.EmployeeUtils;

public class EmployeeService {

    public int getEmployeeCount() {
        return EmployeeUtils.getEmployeeCount();
    }

    public void createEmployee(Employee employee) {
        EmployeeUtils.persistenceEmployee(employee);
    }
}
