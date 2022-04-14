package pro.sky.java.course2.webemployee.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.webemployee.service.DepartmentService;
import pro.sky.java.course2.webemployee.service.Employee;

import java.util.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    DepartmentService departmentService = new DepartmentService();

    @GetMapping("/max-salary")
    public Optional<Employee> maxSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMaxSalaryByTeam(departmentId);
    }

    @GetMapping("/min-salary")
    public Optional<Employee> minSalary(@RequestParam int departmentId) {
        return departmentService.findEmployeeWithMinSalaryByTeam(departmentId);
    }

    @GetMapping("/all/{departmentId}")
    public Collection<String> allTeam(@PathVariable int departmentId) {
        return departmentService.allTeamEmployees(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> all() {
        return departmentService.allEmployees();
    }
}

