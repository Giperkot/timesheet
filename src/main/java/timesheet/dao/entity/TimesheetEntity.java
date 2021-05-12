package timesheet.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "timesheet", schema = "public", catalog = "timesheet")
public class TimesheetEntity {
    private long id;
    private Timestamp createTime;
    private Timestamp workDate;
    private String taskNum;
    private String taskDescription;
    private Long employeId;
    private Long projectId;
    private long timeWasted;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "employe_id")
    public Long getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Long employeId) {
        this.employeId = employeId;
    }

    @Column(name = "project_id")
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "work_date", nullable = false)
    public Timestamp getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Timestamp workDate) {
        this.workDate = workDate;
    }

    @Basic
    @Column(name = "task_num", nullable = false, length = -1)
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
        TimesheetEntity that = (TimesheetEntity) o;
        return id == that.id &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(workDate, that.workDate) &&
                Objects.equals(taskNum, that.taskNum) &&
                Objects.equals(taskDescription, that.taskDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, workDate, taskNum, taskDescription);
    }
}
