package timesheet.dto.timesheet;

import timesheet.dao.entity.ProjectReportEntity;

public class ReportDto {

    private Long projectId;

    private Long sumTimeWasted;

    private Long employeCount;

    public ReportDto(ProjectReportEntity entity) {
        this.projectId = entity.getProjectId();
        this.sumTimeWasted = entity.getSumTimeWasted();
        this.employeCount = entity.getEmployeCount();
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getSumTimeWasted() {
        return sumTimeWasted;
    }

    public void setSumTimeWasted(Long sumTimeWasted) {
        this.sumTimeWasted = sumTimeWasted;
    }

    public Long getEmployeCount() {
        return employeCount;
    }

    public void setEmployeCount(Long employeCount) {
        this.employeCount = employeCount;
    }
}
