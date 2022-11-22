package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.Employee;
import org.ssglobal.training.codes.EmployeeRepository;

public class TestEmployeeRepository {

    private EmployeeRepository employeeRepository;
    
    @BeforeEach
    public void setup() {
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Maria", "Cruz", 50000.00),
                new Employee(102, "Juan", "Luna", 40000.00));
        employeeRepository = new EmployeeRepository(new ArrayList<>(employees));
    }

    @AfterEach
    public void teardown() {
        employeeRepository = null;
    }
    
    @Test
    public void testGetEmployees() {
        List<Employee> actual = employeeRepository.getEmployees();
        List<String> expectedListNames = Arrays.asList("Maria", "Juan");
        double expectedAvgSalary = 35000;
        assertAll(
                () -> {
                    assertIterableEquals(expectedListNames,
                                actual.stream()
                                    .map(Employee::firstname)
                                    .collect(Collectors.toList()));
                },
                () -> {
                    assertEquals(expectedAvgSalary,
                                    actual.stream()
                                    .mapToDouble(Employee::salary)
                                    .average()
                                    .getAsDouble());
                });
    }
}
