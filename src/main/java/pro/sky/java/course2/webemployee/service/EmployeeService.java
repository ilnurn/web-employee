package pro.sky.java.course2.webemployee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.webemployee.exceptions.ArrayFullException;
import pro.sky.java.course2.webemployee.exceptions.BadParamsException;
import pro.sky.java.course2.webemployee.exceptions.EmployeeAddedYetException;


@Service
public class EmployeeService {
    public EmployeeService() {
    }

    Employee[] employees = new Employee[5];


    public String addEmployee(String firstName, String lastName) {
        if (checkEmployee(firstName, lastName)) {
            throw new EmployeeAddedYetException();
        }
        for (int i = 0; i <= employees.length; i++) {
            if (i == employees.length) {
                throw new ArrayFullException();
            } else if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName);
                return employees[i].toString();
            }
        }
        return "";
    }


    public String deleteEmployee(String firstName, String lastName) {
        int i = arrayIndexEmployee(firstName, lastName);
        if (i != -1) {
            employees[i] = null;
            return "{" +
                    "firstName: " + firstName +
                    ", lastName: " + lastName +
                    "}";
        } else {
            throw new BadParamsException();
        }
    }

    public String findEmployee(String firstName, String lastName) {
        if (checkEmployee(firstName, lastName)) {
            return "{" +
                    "firstName: " + firstName +
                    ", lastName: " + lastName +
                    "}";
        } else {
            throw new BadParamsException();
        }
    }

    public boolean checkEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(new Employee(firstName, lastName))) {
                return true;
            }
        }
        return false;
    }
    public int arrayIndexEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(new Employee(firstName, lastName))) {
                return i;
            }
        }
        return -1;
    }
}


