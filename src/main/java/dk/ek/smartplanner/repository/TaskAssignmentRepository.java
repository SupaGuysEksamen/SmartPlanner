package dk.ek.smartplanner.repository;

import dk.ek.smartplanner.model.TaskAssignment;

import java.util.List;

public interface TaskAssignmentRepository {

    void create(TaskAssignment assignment);

    void update(TaskAssignment assignment);

    List<TaskAssignment> findByTaskId(int taskId);

    List<TaskAssignment> findByEmployeeId(int employeeId);

    void delete(int taskId, int employeeId);
}
