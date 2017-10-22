package com.nelson.powermock.mockprivate;

public class EmployeeService {

    public boolean exist(String userName) {
        checkExist(userName);
        return true;
    }

    private void checkExist(String userName) {
        throw new UnsupportedOperationException();
    }
}
