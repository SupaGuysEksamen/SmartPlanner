package dk.ek.smartplanner.model;

import java.math.BigDecimal;

public class TaskAssignment {

    private int taskId;
    private int employeeId;
    private BigDecimal allocatedHours;

    public TaskAssignment() {
    }

    public TaskAssignment(int taskId, int employeeId, BigDecimal allocatedHours) {
        this.taskId = taskId;
        this.employeeId = employeeId;
        this.allocatedHours = allocatedHours;
    }

    /// Getters
    public int getTaskId() {
        return taskId;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public BigDecimal getAllocatedHours() {
        return allocatedHours;
    }

    /// Setters
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public void setAllocatedHours(BigDecimal allocatedHours) {
        this.allocatedHours = allocatedHours;
    }
}