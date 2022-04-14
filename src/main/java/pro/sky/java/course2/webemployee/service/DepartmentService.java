package pro.sky.java.course2.webemployee.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    EmployeeService employeeService = new EmployeeService();

    public Collection<String> allTeamEmployees(int departmentId) {
        Collection<String> allEmployeesOfTeam = employeeService.getAllEmployees().stream()
                .filter(e -> (e.getDepartmentId() == departmentId))
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .collect(Collectors.toList());
        return allEmployeesOfTeam;
    }

    public List<Employee> allEmployees() {
        List<Employee> allEmployee = employeeService.getAllEmployees().stream()
                .sorted(Comparator.comparing(f -> f.getDepartmentId()))
                .collect(Collectors.toList());
        return allEmployee;
    }

    public Optional<Employee> findEmployeeWithMinSalaryByTeam(int departmentId) {
        Optional<Employee> employeeWithMinSalaryByTeam = employeeService.getAllEmployee().stream()
                .filter(e -> (e.getDepartmentId() == departmentId))
                .min(Comparator.comparingInt(p -> p.getSalary()));
        return employeeWithMinSalaryByTeam;
    }

    public Optional<Employee> findEmployeeWithMaxSalaryByTeam(int departmentId) {
        Optional<Employee> employeeWithMinSalaryByTeam = employeeService.getAllEmployee().stream()
                .filter(e -> (e.getDepartmentId() == departmentId))
                .max(Comparator.comparingInt(p -> p.getSalary()));
        return employeeWithMinSalaryByTeam;
    }
}
