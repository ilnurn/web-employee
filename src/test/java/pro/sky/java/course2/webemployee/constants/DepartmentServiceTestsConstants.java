package pro.sky.java.course2.webemployee.constants;

import pro.sky.java.course2.webemployee.service.Employee;

import java.util.List;

public class DepartmentServiceTestsConstants {

    public static Employee ivanIvanov = new Employee("Ivan", "Ivanov", 1, 45000);
    public static Employee petrPetrov = new Employee("Petr", "Petrov", 1, 55000);
    public static Employee semenSemenov = new Employee("Semen", "Semenov", 2, 65000);
    public static Employee alexeyAlexeyev = new Employee("Alexey", "Alexeyev", 2, 75000);
    public static Employee denidDenisov = new Employee("Denis", "Denisov", 3, 85000);
    public static Employee artemArtemov = new Employee("Artem", "Artemov", 3, 95000);

    public static final List<Employee> ALL_TEAM = List.of(
            ivanIvanov,
            petrPetrov,
            semenSemenov,
            alexeyAlexeyev,
            denidDenisov,
            artemArtemov
    );

    public static final List<String> ALL_TEAM_STRING = List.of(
            "department 1: Ivan Ivanov",
            "department 1: Petr Petrov",
            "department 2: Semen Semenov",
            "department 2: Alexey Alexeyev",
            "department 3: Denis Denisov",
            "department 3: Artem Artemov"
    );

    public static final List<String> TEAM_1 = List.of(
            "Ivan Ivanov",
            "Petr Petrov"
    );

    public static final List<String> TEAM_2 = List.of(
            "Semen Semenov",
            "Alexey Alexeyev"
    );

    public static final List<String> TEAM_3 = List.of(
            "Denis Denisov",
            "Artem Artemov"
    );
}
