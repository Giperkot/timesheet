package timesheet.dto.timesheet;

import timesheet.dao.entity.VTimesheetInfoEntity;
import timesheet.utils.ProjectConst;

import java.math.BigDecimal;
import java.util.Date;

public class TimesheetInfoDto {

    private Long id;
    private Long employeId;
    private String lastName;
    private String firstName;
    private String middleName;
    private String position;
    private Long projectId;
    private String projectName;
    private Date workDate;
    private String taskNum;
    private String taskDescription;
    private BigDecimal timeWasted;

    public TimesheetInfoDto() {
    }

    public TimesheetInfoDto(VTimesheetInfoEntity entity) {
        this.id = entity.getId();
        this.projectId = entity.getProjectId();
        this.lastName = entity.getLastName();
        this.firstName = entity.getFirstName();
        this.middleName = entity.getMiddleName();
        this.employeId = entity.getEmployeId();
        this.position = entity.getPosition();
        this.projectName = entity.getProjectName();
        this.workDate = entity.getWorkDate();
        this.taskNum = entity.getTaskNum();
        this.taskDescription = entity.getTaskDescription();
        this.timeWasted = BigDecimal.valueOf(entity.getTimeWasted()).divide(ProjectConst.MINUTES_IN_HOUR);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Long employeId) {
        this.employeId = employeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(String taskNum) {
        this.taskNum = taskNum;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public BigDecimal getTimeWasted() {
        return timeWasted;
    }

    public void setTimeWasted(BigDecimal timeWasted) {
        this.timeWasted = timeWasted;
    }
}
