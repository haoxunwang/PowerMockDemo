package com.nelson.powermock.mockfinal.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.mockfinal.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeDao.class)
public class EmployeeServiceTest {


    @Test
    public void testCreateEmployeeWithMockito() {
        EmployeeDao employeeDao = Mockito.mock(EmployeeDao.class);
        Employee employee = new Employee();
        Mockito.when(employeeDao.insertEmployee(employee)).thenReturn(true);
        EmployeeService employeeService = new EmployeeService(employeeDao);
        employeeService.createEmployee(employee);
        Mockito.verify(employeeDao).insertEmployee(employee);
    }

    @Test
    public void testCreateEmployeeWithPowerMockito() {
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
        Employee employee = new Employee();
        PowerMockito.when(employeeDao.insertEmployee(employee)).thenReturn(true);
        EmployeeService employeeService = new EmployeeService(employeeDao);
        employeeService.createEmployee(employee);
        Mockito.verify(employeeDao).insertEmployee(employee);
    }

}