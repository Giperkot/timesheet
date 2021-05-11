package timesheet.dto.timesheet;

import timesheet.dao.entity.VTimesheetInfoEntity;

import java.sql.Timestamp;
import java.util.Date;

public class TimesheetInfoDto {

    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String position;
    private String projectName;
    private Date workDate;
    private String taskNum;
    private String taskDescription;
    private long timeWasted;

    public TimesheetInfoDto(VTimesheetInfoEntity entity) {
        this.id = entity.getId();
        this.lastName = entity.getLastName();
        this.firstName = entity.getFirstName();
        this.middleName = entity.getMiddleName();
        this.position = entity.getPosition();
        this.projectName = entity.getProjectName();
        this.workDate = entity.getWorkDate();
        this.taskNum = entity.getTaskNum();
        this.taskDescription = entity.getTaskDescription();
        this.timeWasted = entity.getTimeWasted();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getTimeWasted() {
        return timeWasted;
    }

    public void setTimeWasted(long timeWasted) {
        this.timeWasted = timeWasted;
    }
}
