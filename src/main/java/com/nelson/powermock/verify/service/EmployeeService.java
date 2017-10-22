package com.nelson.powermock.verify.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.verify.dao.EmployeeDao;

public class EmployeeService {

    public void saveOrUpdate(Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao();
        long count = employeeDao.getCount(employee);
        if (count > 0) {
            employeeDao.updateEmployee(employee);
        } else {
            employeeDao.saveEmployee(employee);
        }
    }
}
