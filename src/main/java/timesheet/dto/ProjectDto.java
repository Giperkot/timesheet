package timesheet.dto;

import timesheet.dao.entity.ProjectEntity;

import java.util.Date;

public class ProjectDto {

    private long id;
    private Date createTime;
    private String name;

    public ProjectDto(ProjectEntity entity) {
        this.id = entity.getId();
        this.createTime = entity.getCreateTime();
        this.name = entity.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
