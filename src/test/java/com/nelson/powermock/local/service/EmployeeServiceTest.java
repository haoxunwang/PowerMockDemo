package com.nelson.powermock.local.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.local.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

// 显示告诉Junit使用指定的Runner来运行Test Case
@RunWith(PowerMockRunner.class)
// 告诉PowerMock为我提前准备一个xxx的class
@PrepareForTest(EmployeeService.class)
public class EmployeeServiceTest {

    @Test
    public void testGetTotalEmployee() {
        EmployeeService service = new EmployeeService();
        int total = service.getTotalEmployee();
        assertEquals(10, total);
    }

    @Test
    public void testGetTotalEmployeeWithMock() {
        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
        try {
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            PowerMockito.when(employeeDao.getTotal()).thenReturn(10);
            EmployeeService service = new EmployeeService();
            int total = service.getTotalEmployee();
            assertEquals(10, total);
        } catch (Exception e) {
            fail("测试失败！");
        }

    }

    @Test
    public void testCreateEmployee() {
        EmployeeService service = new EmployeeService();
        Employee employee = new Employee();
        service.createEmployee(employee);
    }

    @Test
    public void testCreateEmployeeWithMock() {

        EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
        try {
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            EmployeeService service = new EmployeeService();
            service.createEmployee(employee);
            Mockito.verify(employeeDao).addEmployee(employee);
        } catch (Exception e) {
            fail();
        }
    }

}