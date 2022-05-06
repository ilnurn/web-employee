package pro.sky.java.course2.webemployee.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.webemployee.exceptions.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<String> allTeamEmployees(int departmentId) {
        checkDepartmentId(departmentId);
        List<String> allEmployeesOfTeam = employeeService.getAllEmployees().stream()
                .filter(e -> (e.getDepartmentId() == departmentId))
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .collect(Collectors.toList());
        return allEmployeesOfTeam;
    }

    public List<String> allEmployees() {
        List<String> allEmployees = employeeService.getAllEmployees().stream()
                .sorted(Comparator.comparing(f -> f.getDepartmentId()))
                .map(p -> "department " + p.getDepartmentId() + ": " + p.getFirstName() + " " + p.getLastName())
                .collect(Collectors.toList());
        return allEmployees;
    }

    public Optional<Employee> findEmployeeWithMinSalaryByTeam(int departmentId) {
        checkDepartmentId(departmentId);
        Optional<Employee> employeeWithMinSalaryByTeam = employeeService.getAllEmployee().stream()
                .filter(e -> (e.getDepartmentId() == departmentId))
                .min(Comparator.comparingInt(p -> p.getSalary()));
        return employeeWithMinSalaryByTeam;
    }

    public Optional<Employee> findEmployeeWithMaxSalaryByTeam(int departmentId) {
        checkDepartmentId(departmentId);
        Optional<Employee> employeeWithMinSalaryByTeam = employeeService.getAllEmployee().stream()
                .filter(e -> (e.getDepartmentId() == departmentId))
                .max(Comparator.comparingInt(p -> p.getSalary()));
        return employeeWithMinSalaryByTeam;
    }

    private void checkDepartmentId(int departmentId) {
        boolean department = false;
        for (Employee employee : employeeService.getAllEmployees()) {
            if (employee.getDepartmentId() == departmentId) {
                department = true;
                break;
            }
        }
        if (department == false) {
            throw new NotFoundException("Такого отдела не существует");
        }
    }
}
