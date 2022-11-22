package org.ssglobal.training.codes;

import java.util.List;
import java.util.stream.Stream;

public class EmployeeRepository {
    private List<Employee> employeeTbl;

    public EmployeeRepository(List<Employee> employeeTbl) {
        this.employeeTbl = employeeTbl;
    }

    public List<Employee> getEmployees() {
        return employeeTbl;
    }

    public Stream<Employee> getEmployeeStream() {
        return employeeTbl.stream();
    }
    
}
