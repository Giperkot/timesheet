package timesheet.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import timesheet.dto.ExceptionDTO;
import timesheet.exceptions.UserException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({UserException.class})
    @ResponseBody
    public Object userExceptionHandler(UserException ex) {
        return new ExceptionDTO(ex);
    }

}
