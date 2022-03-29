package pro.sky.java.course2.webemployee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.webemployee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeService employeeService = new EmployeeService();

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.addEmployee(firstName, lastName);
        return "{" +
                "firstName: " + firstName +
                ", lastName: " + lastName +
                "}";
    }

    @GetMapping("/remove")
    public String delete(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.deleteEmployee(firstName, lastName);
        return "{" +
                "firstName: " + firstName +
                ", lastName: " + lastName +
                "}";
    }

    @GetMapping("/find")
    public String find(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.findEmployee(firstName, lastName);
        return "{" +
                "firstName: " + firstName +
                ", lastName: " + lastName +
                "}";
    }

    @GetMapping("/list")
    public String printList() {
        return employeeService.printList();
    }
}
