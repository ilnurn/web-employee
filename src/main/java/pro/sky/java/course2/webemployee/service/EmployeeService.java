package pro.sky.java.course2.webemployee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.webemployee.exceptions.BadParamsException;
import pro.sky.java.course2.webemployee.exceptions.EmployeeAddedYetException;
import pro.sky.java.course2.webemployee.exceptions.InvalidNameException;
import pro.sky.java.course2.webemployee.exceptions.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        validateNames(firstName, lastName);

        Employee newEmployee = new Employee(
                capitalize(firstName.toLowerCase()),
                capitalize(lastName.toLowerCase()),
                departmentId,
                salary
        );

        if (employees.get(firstName + lastName) != null) {
            throw new EmployeeAddedYetException();
        } else {
            employees.put(firstName + lastName, newEmployee);
        }
        return newEmployee;
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee;
        if (employees.get(firstName + lastName) == null) {
            throw new BadParamsException();
        } else {
            employee = employees.get(firstName + lastName);
            employees.remove(firstName + lastName);
        }
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        if (employees.get(firstName + lastName) != null) {
            return employees.get(firstName + lastName);
        } else {
            throw new NotFoundException("Сотрудник " + firstName + " " + lastName + " не найден");
        }
    }

    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    private void validateNames(String... names) {
        for (String name : names) {
            if (!isAlpha(name)) {
                throw new InvalidNameException(name);
            }
        }
    }
}



