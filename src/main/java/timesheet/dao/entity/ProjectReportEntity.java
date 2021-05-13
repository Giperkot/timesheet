package timesheet.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProjectReportEntity {

    private Long projectId;

    private Long sumTimeWasted;

    private Long employeCount;

    private String projectName;

    @Id
    @Column(name = "project_id")
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Column(name = "sum_time_wasted")
    public Long getSumTimeWasted() {
        return sumTimeWasted;
    }

    public void setSumTimeWasted(Long sumTimeWasted) {
        this.sumTimeWasted = sumTimeWasted;
    }

    @Column(name = "employe_count")
    public Long getEmployeCount() {
        return employeCount;
    }

    public void setEmployeCount(Long employeCount) {
        this.employeCount = employeCount;
    }

    @Column(name = "project_name")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
