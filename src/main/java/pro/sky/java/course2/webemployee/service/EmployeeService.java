package pro.sky.java.course2.webemployee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.webemployee.exceptions.BadParamsException;
import pro.sky.java.course2.webemployee.exceptions.EmployeeAddedYetException;
import pro.sky.java.course2.webemployee.exceptions.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap(Map.of(
            "IvanIvanov",
            new Employee("Ivan", "Ivanov", 1, 100),
            "PetrPetrov",
            new Employee("Petr", "Petrov", 1, 100),
            "AlexandrSmirnov",
            new Employee("Alexandr", "Smirnov", 1, 200),
            "AlexeyMashkov",
            new Employee("Alexey", "Mashkov", 2, 100),
            "AndreyAndreev",
            new Employee("Andrey", "Andreev", 3, 500),
            "VasiliyVasilyev",
            new Employee("Vasiliy", "Vasilyev", 4, 200)
    ));

    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        if (employees.get(firstName + lastName) != null) {
            throw new EmployeeAddedYetException();
        } else {
            employees.put(firstName + lastName, new Employee(firstName, lastName, departmentId, salary));
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

    public List<Employee> getAllEmployee() {
        return employees.entrySet()
                .stream()
                .map(e -> e.getValue())
                .collect(Collectors.toList());
    }
}



