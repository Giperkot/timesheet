package timesheet.dto;

import timesheet.dao.entity.EmployeEntity;

import java.util.Date;

public class EmployeDto {

    private long id;
    private Date createTime;
    private String lastName;
    private String firstName;
    private String middleName;
    private String position;

    public EmployeDto(EmployeEntity entity) {
        this.id = entity.getId();
        this.createTime = entity.getCreateTime();
        this.lastName = entity.getLastName();
        this.firstName = entity.getFirstName();
        this.middleName = entity.getMiddleName();
        this.position = entity.getPosition();
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
}
