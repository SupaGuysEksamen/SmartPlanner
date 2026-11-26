package dk.ek.smartplanner.model;

import java.time.LocalDate;

public class Project {
    private int id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private Integer parentProjectId;    // null = hovedprojekt


    public Project() {
    }

    public Project(int id, String name,String description, LocalDate startDate,
                   LocalDate endDate, String status,Integer parentProjectId){

        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.parentProjectId = parentProjectId;
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
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public String getStatus() {
        return status;
    }
    public Integer getParentProjectId() {
        return parentProjectId;
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
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setParentProjectId(Integer parentProjectId) {
        this.parentProjectId = parentProjectId;
    }
}
