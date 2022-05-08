package pro.sky.java.course2.webemployee.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.webemployee.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.webemployee.constants.DepartmentServiceTestsConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentService out;

    @Test
    public void shouldCallEmployeeServiceMethodWhenAllTeamEmployees() {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(ALL_TEAM);

        assertIterableEquals(out.allTeamEmployees(1), TEAM_1);
        assertIterableEquals(out.allTeamEmployees(2), TEAM_2);
        assertIterableEquals(out.allTeamEmployees(3), TEAM_3);
    }

    @Test
    public void shouldCallEmployeeServiceMethodWhenFindEmployeeWithMinSalaryByTeam() {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(ALL_TEAM);

        assertEquals(out.findEmployeeWithMinSalaryByTeam(1).get(), ivanIvanov);
        assertEquals(out.findEmployeeWithMinSalaryByTeam(2).get(), semenSemenov);
        assertEquals(out.findEmployeeWithMinSalaryByTeam(3).get(), denidDenisov);
    }

    @Test
    public void shouldCallEmployeeServiceMethodWhenFindEmployeeWithMaxSalaryByTeam() {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(ALL_TEAM);

        assertEquals(out.findEmployeeWithMaxSalaryByTeam(1).get(), petrPetrov);
        assertEquals(out.findEmployeeWithMaxSalaryByTeam(2).get(), alexeyAlexeyev);
        assertEquals(out.findEmployeeWithMaxSalaryByTeam(3).get(), artemArtemov);
    }

    @Test
    public void shouldCallEmployeeServiceMethodWhenAllEmployees() {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(ALL_TEAM);

        assertIterableEquals(out.allEmployees(), ALL_TEAM);
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenAllTeamEmployees() {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(ALL_TEAM);

        assertThrows(NotFoundException.class, () -> out.allTeamEmployees(4));
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenFindEmployeeWithMinSalaryByTeam() {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(ALL_TEAM);

        assertThrows(NotFoundException.class, () -> out.findEmployeeWithMinSalaryByTeam(4));
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenFindEmployeeWithMaxSalaryByTeam() {
        when(employeeServiceMock.getAllEmployees())
                .thenReturn(ALL_TEAM);

        assertThrows(NotFoundException.class, () -> out.findEmployeeWithMaxSalaryByTeam(4));
    }
}
