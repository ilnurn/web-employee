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

    public static final List<Employee> TEAM_1 = List.of(
            ivanIvanov,
            petrPetrov
    );

    public static final List<Employee> TEAM_2 = List.of(
            semenSemenov,
            alexeyAlexeyev
    );

    public static final List<Employee> TEAM_3 = List.of(
           denidDenisov,
            artemArtemov
    );
}
