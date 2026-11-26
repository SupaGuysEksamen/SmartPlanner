package dk.ek.smartplanner.repository.impl;

import dk.ek.smartplanner.model.TaskAssignment;
import dk.ek.smartplanner.repository.TaskAssignmentRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskAssignmentRepositoryImpl implements TaskAssignmentRepository {

private final JdbcTemplate jdbcTemplate;

public TaskAssignmentRepositoryImpl (JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public void create(TaskAssignment assignment) {
    String sql = "INSERT INTO assigment (task_id, employee_id, allocated_hours VALUES (?,?,?) ";

    jdbcTemplate.update(sql,assignment.getTaskId(),assignment.getEmployeeID(),assignment.getAllocatedHours());
    }

    public void update(TaskAssignment assignment) {
    String sql = "UPDATE task_assignment SET allocated_hours = ? WHERE task_id = ? AND employee_id = ?";

    jdbcTemplate.update(sql,assignment.getAllocatedHours(),assignment.taskId(), assignment.getEmployeeId());
    }

    public List<TaskAssignment> findByTaskId(int taskId) {
    String sql = "SELECT * FROM task_assignment WHERE task_id = ?";

    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TaskAssignment.class), taskId);
    }

    public List<TaskAssignment> findByEmployeeId(int employeeId) {
    String sql = "SELECT * FROM task_assignment WHERE employee_id = ?";

    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TaskAssignment.class), employeeId);
    }
}
