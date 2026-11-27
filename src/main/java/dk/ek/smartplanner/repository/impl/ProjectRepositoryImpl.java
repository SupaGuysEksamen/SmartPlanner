package dk.ek.smartplanner.repository.impl;

import dk.ek.smartplanner.model.Project;
import dk.ek.smartplanner.repository.ProjectRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProjectRepositoryImpl (JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate;}

    public void create(Project project) {
        String sql = "INSERT INTO project (name, description, start_date, end_date, status, parent_project_id) VALUES (?,?,?,?,?,?)";

        jdbcTemplate.update(sql, project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate(), project.getStatus(), project.getParentProjectId());
    }

    public Project findById(int id) {
        String sql = "SELECT * FROM project WHERE id = ?";

        List<Project> projects = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Project.class), id);

        if (projects.isEmpty()) {
            return null;
        }
        return projects.get(0);
    }
    public void update(Project project) {
        String sql = "UPDATE project SET name = ?, description = ?, start_date = ?, end_date = ?, status = ?, parent_project_id = ?, WHERE id = ?";

        jdbcTemplate.update(sql, project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate(), project.getStatus(), project.getParentProjectId(), project.getId());
    }

    public void delete(int id) {
        String sql ="DELETE FROM project WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }

    public List<Project> findByParentProjectId(int projectId) {
        String sql = "SELECT * FROM project WHERE parent_project_id = ?";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Project.class), projectId);
    }
    public List<Project> findTopLevelByUserId(int userId) {
        String sql = "SELECT * FROM project WHERE parent_project_id is NULL AND id IN (SELECT project_id FROM project_user WHERE user_id = ?)";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Project.class),userId);
    }

    public void addUser(int projectId, int userId) {
        String sql = "INSERT INTO project_user (project_id, user_id) VALUES (?,?)";

        jdbcTemplate.update(sql, projectId, userId);
    }

    public void removeUser(int projectId, int userId) {

        String sql = "DELETE FROM project_user WHERE project_id = ? AND user_id = ?";

        jdbcTemplate.update(sql, projectId, userId);
    }

    public void deleteByParentProjectId(int parentProjectId) {
        String sql = "DELETE FROM project WHERE parent_project_id = ?";

        jdbcTemplate.update(sql, parentProjectId);
    }
}
