package pro.sky.java.course2.webemployee.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<String> allTeamEmployees(int departmentId) {
        List<String> allEmployeesOfTeam = employeeService.getAllEmployees().stream()
                .filter(e -> (e.getDepartmentId() == departmentId))
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .collect(Collectors.toList());
        return allEmployeesOfTeam;
    }

    public List<String> allEmployees() {
       List<String> allEmployees = employeeService.getAllEmployees().stream()
                .sorted(Comparator.comparing(f -> f.getDepartmentId()))
                .map(p-> "department " + p.getDepartmentId() + ": " + p.getFirstName() + " " + p.getLastName())
                .collect(Collectors.toList());
        return allEmployees;
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
