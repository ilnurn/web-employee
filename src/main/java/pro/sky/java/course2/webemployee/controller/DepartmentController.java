package pro.sky.java.course2.webemployee.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.webemployee.service.DepartmentService;
import pro.sky.java.course2.webemployee.service.Employee;

import java.util.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Optional<Employee> maxSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMaxSalaryByTeam(departmentId);
    }

    @GetMapping("/min-salary")
    public Optional<Employee> minSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMinSalaryByTeam(departmentId);
    }

    @GetMapping("/all")
    public List<String> allTeam(@RequestParam(required = false) Integer departmentId) {
        if (departmentId != null)
            return departmentService.allTeamEmployees(departmentId);
        else
            return departmentService.allEmployees();
    }
}

