package com.nelson.powermock.construction.dao;

import com.nelson.powermock.common.Employee;

public class EmployeeDao {

    public enum Dialect {
        MYSQL,
        ORACLE
    }


    public EmployeeDao(boolean lazy, Dialect dialect) {
        throw new UnsupportedOperationException();
    }

    public void insertEmployee(Employee employee) {
        throw new UnsupportedOperationException();
    }

}
