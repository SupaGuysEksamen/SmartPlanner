package dk.ek.smartplanner.repository;

import dk.ek.smartplanner.model.Competence;

import java.util.List;

public interface CompetenceRepository {

    List<Competence> findByEmployeeId(int employeeId);
}
