package dk.ek.smartplanner.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Task {

    private int id;
    private String name;
    private String description;
    private BigDecimal estimatedHours;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private int projectId;
    private Integer parentTaskId;   // null = hovedopgave

    public Task() {
    }

    public Task(int id, String name, String description, BigDecimal estimatedHours,
                LocalDate startDate, LocalDate endDate, String status, int projectId, Integer parentTaskId) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.estimatedHours = estimatedHours;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.projectId = projectId;
        this.parentTaskId = parentTaskId;
    }

    /// Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getEstimatedHours() {
        return estimatedHours;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public String getStatus() {
        return status;
    }
    public int getProjectId() {
        return projectId;
    }
    public Integer getParentTaskId() {
        return parentTaskId;
    }

    /// Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setEstimatedHours(BigDecimal estimatedHours) {
        this.estimatedHours = estimatedHours;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public void setParentTaskId(Integer parentTaskId) {
        this.parentTaskId = parentTaskId;
    }
}
