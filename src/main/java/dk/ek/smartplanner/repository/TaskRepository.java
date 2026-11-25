package dk.ek.smartplanner.repository;

import dk.ek.smartplanner.model.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> findByProjectId(int projectId);

    List<Task> findByParentTaskId(int parentTaskId);

    void deleteByProject(int projectId);

    void deleteByParentTaskId(int parentTaskId);
}
