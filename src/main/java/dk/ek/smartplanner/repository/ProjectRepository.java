package dk.ek.smartplanner.repository;

import dk.ek.smartplanner.model.Project;

import java.util.List;

public interface ProjectRepository {

    List<Project> findByParentProjectId(int projectId);

    List<Project> findTopLevelByUserId(int userId);

    void addUser(int projectId, int userId);

    void removeUser(int projectId, int userId);

    void deleteByParentProjectId(int parentProjectId);
}
