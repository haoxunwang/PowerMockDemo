package com.nelson.powermock.mockprivate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.fail;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeService.class)
public class EmployeeServiceTest {

    @Test
    public void testExist() {
        EmployeeService employeeService = PowerMockito.spy(new EmployeeService());
        try {
            PowerMockito.doNothing().when(employeeService, "checkExist", "haoxunwang");
            boolean result = employeeService.exist("haoxunwang");
            Assert.assertTrue(result);
            PowerMockito.verifyPrivate(employeeService).invoke("checkExist", "haoxunwang");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}