package pro.sky.java.course2.webemployee.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.webemployee.exceptions.BadParamsException;
import pro.sky.java.course2.webemployee.exceptions.EmployeeAddedYetException;
import pro.sky.java.course2.webemployee.exceptions.InvalidNameException;
import pro.sky.java.course2.webemployee.exceptions.NotFoundException;

import java.util.stream.Stream;

import static pro.sky.java.course2.webemployee.constants.EmployeeServiceTestConstants.*;

class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeService();

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(CORRECT_NAME, CORRECT_LAST_NAME, 4, 40000),
                Arguments.of(LOWER_CASE_NAME, LOWER_CASE_LAST_NAME, 4, 40000),
                Arguments.of(UPPER_CASE_NAME, UPPER_CASE_LAST_NAME, 4, 40000)
        );
    }

    public static Stream<Arguments> provideParamsForInvalidNameExceptionTests() {
        return Stream.of(
                Arguments.of(ILLEGAL_CHARACTERS_NAME, CORRECT_LAST_NAME, 1, 45000),
                Arguments.of(CORRECT_NAME, ILLEGAL_CHARACTERS_NAME, 2, 55000)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldAddCorrectNames(String firstName, String lastName, int departmentId, int salary) {
        Assertions.assertEquals(out.addEmployee(firstName, lastName, departmentId, salary), new Employee(CORRECT_NAME, CORRECT_LAST_NAME, departmentId, salary));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForInvalidNameExceptionTests")
    public void shouldThrowInvalidNameException(String firstName, String lastName, int departmentId, int salary) {
        Assertions.assertThrows(InvalidNameException.class, () -> out.addEmployee(firstName, lastName, departmentId, salary));
    }

    @Test
    public void shouldThrowEmployeeAddedYetException() {
        out.addEmployee(CORRECT_NAME, CORRECT_LAST_NAME, 2, 25000);
        Assertions.assertThrows(EmployeeAddedYetException.class, () -> out.addEmployee(CORRECT_NAME, CORRECT_LAST_NAME, 4, 4000));
    }

    @Test
    public void shouldThrowBadParamsException() {
        Assertions.assertThrows(BadParamsException.class, () -> out.deleteEmployee(CORRECT_NAME, CORRECT_LAST_NAME));
    }

    @Test
    public void shouldThrowNotFoundException() {
        Assertions.assertThrows(NotFoundException.class, () -> out.findEmployee(CORRECT_NAME, CORRECT_LAST_NAME));
    }

    @Test
    public void shouldFindEmployee() {
        out.addEmployee(CORRECT_NAME, CORRECT_LAST_NAME, 2, 25000);
        Assertions.assertEquals(out.findEmployee(CORRECT_NAME, CORRECT_LAST_NAME), new Employee(CORRECT_NAME, CORRECT_LAST_NAME, 2, 25000));
    }

    @Test
    public void shouldDeleteEmployee() {
        Assertions.assertEquals(out.addEmployee(CORRECT_NAME, CORRECT_LAST_NAME, 2, 25000), new Employee(CORRECT_NAME, CORRECT_LAST_NAME, 2, 25000));
        out.deleteEmployee(CORRECT_NAME, CORRECT_LAST_NAME);
        Assertions.assertThrows(NotFoundException.class, () -> out.findEmployee(CORRECT_NAME, CORRECT_LAST_NAME));
    }
}