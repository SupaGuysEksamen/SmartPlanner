package dk.ek.smartplanner.repository;

import dk.ek.smartplanner.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    Employee findByName(String name);

    List<Employee> findByCompetenceId(int competenceId);

    void addCompetence(int employeeId, int competenceId);

    void removeCompetence(int employeeId, int competenceId);
}
