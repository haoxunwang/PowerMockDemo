package com.nelson.powermock.construction.service;

import com.nelson.powermock.common.Employee;
import com.nelson.powermock.construction.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static com.nelson.powermock.construction.dao.EmployeeDao.Dialect.MYSQL;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class EmployeeServiceTest {

    @Test
    public void testCreateEmployee() {

        EmployeeDao employeeDao = mock(EmployeeDao.class);
        try {
            whenNew(EmployeeDao.class).withArguments(false, MYSQL).thenReturn(employeeDao);
            EmployeeService employeeService = new EmployeeService();
            Employee employee = new Employee();
            employeeService.createEmployee(employee);
            verify(employeeDao).insertEmployee(employee);

        } catch (Exception e) {
            fail();
        }
    }

}