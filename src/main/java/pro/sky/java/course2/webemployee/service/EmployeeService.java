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


    public String addEmployee(String e, String f) {
        if (checkEmployee(e, f)) {
            throw new EmployeeAddedYetException();
        }
        for (int i = 0; i <= employees.length; i++) {
            if (i == employees.length) {
                throw new ArrayFullException();
            } else if (employees[i] == null) {
                employees[i] = new Employee(e, f);
                return employees[i].toString();
            }
        }
        return "";
    }


    public String deleteEmployee(String e, String f) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(new Employee(e, f))) {
                employees[i] = null;
                return employees[i].toString();
            }
        }

        return "";
    }

    public String findEmployee(String e, String f) {
        if (checkEmployee(e, f)) {
            return "{" +
                    "firstName: " + e +
                    ", lastName: " + f +
                    "}";
        } else {
            throw new BadParamsException();
        }
    }

    public boolean checkEmployee(String e, String f) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(new Employee(e, f))) {
                return true;
            }
        }
        return false;
    }
}


