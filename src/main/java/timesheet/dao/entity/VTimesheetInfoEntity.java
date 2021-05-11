package timesheet.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "v_timesheet_info", schema = "public", catalog = "timesheet")
public class VTimesheetInfoEntity {
    private Long id;
    private Timestamp createTime;
    private String lastName;
    private String firstName;
    private String middleName;
    private String position;
    private String projectName;
    private Timestamp workDate;
    private String taskNum;
    private String taskDescription;
    private long timeWasted;

    @Id
    @Column(name = "id", nullable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = -1)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = -1)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "middle_name", nullable = true, length = -1)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "position", nullable = true, length = -1)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "project_name", nullable = true, length = -1)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "work_date", nullable = true)
    public Timestamp getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Timestamp workDate) {
        this.workDate = workDate;
    }

    @Basic
    @Column(name = "task_num", nullable = true, length = -1)
    public String getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(String taskNum) {
        this.taskNum = taskNum;
    }

    @Basic
    @Column(name = "task_description", nullable = true, length = -1)
    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Column(name = "time_wasted")
    public long getTimeWasted() {
        return timeWasted;
    }

    public void setTimeWasted(long timeWasted) {
        this.timeWasted = timeWasted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VTimesheetInfoEntity that = (VTimesheetInfoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(position, that.position) &&
                Objects.equals(projectName, that.projectName) &&
                Objects.equals(workDate, that.workDate) &&
                Objects.equals(taskNum, that.taskNum) &&
                Objects.equals(taskDescription, that.taskDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middleName, position, projectName, workDate, taskNum, taskDescription);
    }
}
