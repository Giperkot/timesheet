package timesheet.dto.timesheet;

import timesheet.dao.entity.ProjectReportEntity;
import timesheet.utils.ProjectConst;

import java.math.BigDecimal;

public class ReportDto {

    private Long projectId;

    private BigDecimal sumTimeWasted;

    private Long employeCount;

    private String projectName;

    public ReportDto(ProjectReportEntity entity) {
        this.projectId = entity.getProjectId();
        this.sumTimeWasted = BigDecimal.valueOf(entity.getSumTimeWasted()).divide(ProjectConst.MINUTES_IN_HOUR);
        this.employeCount = entity.getEmployeCount();
        this.projectName = entity.getProjectName();
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getSumTimeWasted() {
        return sumTimeWasted;
    }

    public void setSumTimeWasted(BigDecimal sumTimeWasted) {
        this.sumTimeWasted = sumTimeWasted;
    }

    public Long getEmployeCount() {
        return employeCount;
    }

    public void setEmployeCount(Long employeCount) {
        this.employeCount = employeCount;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
