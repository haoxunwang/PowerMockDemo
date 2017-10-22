package com.nelson.powermock.mockstatic.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.mockstatic.EmployeeUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeUtils.class)
public class EmployeeServiceTest {

    @Ignore
    @Test
    public void testGetEmployeeCount() {
        EmployeeService employeeService = new EmployeeService();
        int count = employeeService.getEmployeeCount();
        assertEquals(10, count);
    }

    @Ignore
    @Test
    public void testCreateEmployee() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee();
        employeeService.createEmployee(employee);
        assertTrue(true);
    }


    @Test
    public void testGetEmployeeCountWithMock() {
        PowerMockito.mockStatic(EmployeeUtils.class);
        PowerMockito.when(EmployeeUtils.getEmployeeCount()).thenReturn(10);
        EmployeeService employeeService = new EmployeeService();
        int count = employeeService.getEmployeeCount();
        assertEquals(10, count);
    }

    @Test
    public void testCreateEmployeeWithMock() {
        PowerMockito.mockStatic(EmployeeUtils.class);
        PowerMockito.doNothing().when(EmployeeUtils.class);
        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee();
        employeeService.createEmployee(employee);
        PowerMockito.verifyStatic();
    }


}