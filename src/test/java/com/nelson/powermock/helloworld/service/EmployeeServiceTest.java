package com.nelson.powermock.helloworld.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.helloworld.dao.EmployeeDao;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.*;

public class EmployeeServiceTest {


    @Test
    public void testGetTotalEmployee() throws Exception {
        EmployeeDao employeeDao = new EmployeeDao();
        EmployeeService service = new EmployeeService(employeeDao);
        int total = service.getTotalEmployee();
        assertEquals(10, total);
    }


    @Test
    public void testGetTotalEmployeeWithMock() throws Exception {
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
        PowerMockito.when(employeeDao.getTotal()).thenReturn(10);
        EmployeeService service = new EmployeeService(employeeDao);
        int total = service.getTotalEmployee();
        assertEquals(10, total);
    }

    @Test
    public void testCreateEmployee() {
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
        Employee employee = new Employee();
        PowerMockito.doNothing().when(employeeDao).addEmployee(employee);
        EmployeeService service = new EmployeeService(employeeDao);
        service.createEmployee(employee);

        // verify the mothod invocation.
        Mockito.verify(employeeDao).addEmployee(employee);
    }


}