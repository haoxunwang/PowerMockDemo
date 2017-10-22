package com.nelson.powermock.verify.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.verify.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.fail;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class EmployeeServiceTest {

    @Test
    public void testSaveOrUpdateCountLessZero() {
        try {
            EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(0L);
            EmployeeService service = new EmployeeService();
            service.saveOrUpdate(employee);
            Mockito.verify(employeeDao).saveEmployee(employee);
            Mockito.verify(employeeDao, Mockito.never()).updateEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testSaveOrUpdateCountMoreThanZero() {
        try {
            EmployeeDao employeeDao = PowerMockito.mock(EmployeeDao.class);
            PowerMockito.whenNew(EmployeeDao.class).withNoArguments().thenReturn(employeeDao);
            Employee employee = new Employee();
            PowerMockito.when(employeeDao.getCount(employee)).thenReturn(1L);
            EmployeeService service = new EmployeeService();
            service.saveOrUpdate(employee);
            Mockito.verify(employeeDao, Mockito.never()).saveEmployee(employee);
            Mockito.verify(employeeDao, Mockito.times(1)).updateEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}