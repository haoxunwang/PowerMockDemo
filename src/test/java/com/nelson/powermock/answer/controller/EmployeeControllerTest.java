package com.nelson.powermock.answer.controller;

import com.nelson.powermock.answer.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Test
    public void testGetEmail() throws Exception {
        EmployeeService employeeService = PowerMockito.mock(EmployeeService.class);
        PowerMockito.when(employeeService.findEmailByUserName(Mockito.anyString())).then(
                invocation -> {
                    String argument = (String) invocation.getArguments()[0];
                    if ("haoxunwang".equals(argument))
                        return "haoxunwang525@gmail.com";
                    else if ("jolly".equals(argument))
                        return "jolly@gmail.com";
                    throw new NullPointerException();
                }
        );

        try {

            PowerMockito.whenNew(EmployeeService.class).withNoArguments().thenReturn(employeeService);
            EmployeeController controller = new EmployeeController();
            String email = controller.getEmail("jolly");
            Assert.assertEquals("jolly@gmail.com", email);
            email = controller.getEmail("nelson");
            Assert.assertEquals("nelson@gamil.com", email);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof NullPointerException);
        }
    }

}