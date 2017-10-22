package com.nelson.powermock.matcher.controller;

import com.nelson.powermock.matcher.service.EmployeeService;
import org.junit.Test;
import org.mockito.ArgumentMatcher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

public class EmployeeControllerTest {

    @Test
    public void testGetEmail() {

        EmployeeService employeeService = mock(EmployeeService.class);
        when(employeeService.findEmailByUserName(argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(Object argument) {
                String arg = (String) argument;
                if (arg.startsWith("nelson") || arg.startsWith("haoxunwang")) {
                    return true;
                } else {
                    throw new RuntimeException();
                }
            }
        }))).thenReturn("haoxunwang525@gamil.com");

        try {
            whenNew(EmployeeService.class).withAnyArguments().thenReturn(employeeService);
            EmployeeController controller = new EmployeeController();
            String email = controller.getEmail("haoxunwang");
            assertEquals("haoxunwang525@gamil.com", email);
            assertEquals("nelson", email);
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

}