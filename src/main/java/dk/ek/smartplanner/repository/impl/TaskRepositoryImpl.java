package dk.ek.smartplanner.repository.impl;

import dk.ek.smartplanner.model.Task;
import dk.ek.smartplanner.repository.TaskAssignmentRepository;
import dk.ek.smartplanner.repository.TaskRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.beans.BeanProperty;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    public TaskRepositoryImpl (JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}


    public void create(Task task) {
        String sql = "INSERT INTO task (name, description, estimated_hours, start_date, end_date, status, project_id, parent_task_id)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,task.getName(),task.getDescription(), task.getEstimatedHours(), task.getStartDate(), task.getEndDate(), task.getStatus(), task.getProjectId(), task.getParentTaskId());
    }
    public Task findById(int id) {

        String sql = "SELECT * FROM task WHERE = ?";
        List<Task> tasks = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Task.class), id);

        if(tasks.isEmpty()) {
            return null;
        }
        return tasks.get(0);
    }

    public List<Task> findByProjectId(int projectId) {
        String sql = "SELECT * FROM task WHERE project_id = ?";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Task.class), projectId);
    }

    public List<Task> findByParentTaskId(int parentTaskId) {
        String sql = "SELECT * FROM task WHERE parent_task_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Task.class), parentTaskId);
    }

    public void update(Task task) {
        String sql = "UDATE task SET name = ?, description = ?, estimated_hours = ?, start_date = ?, end_date = ?, status = ?, parent_task_id = ? WHERE id = ?";

        jdbcTemplate.update(sql, task.getName(), task.getDescription(), task.getEstimatedHours(), task.getStartDate(), task.getEndDate(), task.getStatus(), task.getParentTaskId(), task.getId());
    }
    public void delete(int id) {
        String sql = "DELETE FROM task WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }

    public void deleteByProject(int projectId) {
        String sql = "DELETE FROM task WHERE project_id = ?";

        jdbcTemplate.update(sql, projectId);
    }

    public void deleteByParentTaskId(int parentTaskId) {
        String sql = "DELETE FROM task WHERE parent_task_id = ?";

        jdbcTemplate.update(sql,parentTaskId);
    }
}
