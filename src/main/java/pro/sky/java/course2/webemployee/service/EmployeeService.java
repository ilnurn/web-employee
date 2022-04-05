package pro.sky.java.course2.webemployee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.webemployee.exceptions.BadParamsException;
import pro.sky.java.course2.webemployee.exceptions.EmployeeAddedYetException;

import java.util.*;


@Service
public class EmployeeService {
    private final Map<Employee, Integer> employees = new HashMap();


    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int id=0;
        id++;
        if (employees.get(employee)!=null) {
            throw new EmployeeAddedYetException();
        } else {
            employees.put(employee, id);
        }
        return employee;
    }


    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.get(employee) == null) {
            throw new BadParamsException();
        } else {
            employees.remove(employee);
        }
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.get(employee) != null) {
            return employee;
        } else {
            throw new BadParamsException();
        }
    }

    public Set<Employee> getAllEmployees() {
        return (Set<Employee>) employees.keySet();
    }
}



