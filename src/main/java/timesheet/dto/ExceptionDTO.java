package timesheet.dto;

import timesheet.exceptions.UserException;

public class ExceptionDTO {

    private String message;

    public ExceptionDTO(UserException ex) {
        this.message = ex.getMsg();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
