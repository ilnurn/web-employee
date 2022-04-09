package pro.sky.java.course2.webemployee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.webemployee.exceptions.BadParamsException;
import pro.sky.java.course2.webemployee.exceptions.EmployeeAddedYetException;
import pro.sky.java.course2.webemployee.exceptions.NotFoundException;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap();

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.get(firstName + lastName)!=null) {
            throw new EmployeeAddedYetException();
        } else {
            employees.put(firstName + lastName, new Employee(firstName,lastName));
        }
        return employees.get(firstName + lastName);
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
}



