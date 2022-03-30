package pro.sky.java.course2.webemployee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.webemployee.exceptions.BadParamsException;
import pro.sky.java.course2.webemployee.exceptions.EmployeeAddedYetException;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
    }

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAddedYetException();
        } else {
            employees.add(employee);
        }
        return employee;
    }


    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new BadParamsException();
        } else {
            employees.remove(employee);
        }
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(new Employee(firstName, lastName))) {
            return employee;
        } else {
            throw new BadParamsException();
        }
    }

    public List<Employee> printList() {
        return employees;
    }
}



