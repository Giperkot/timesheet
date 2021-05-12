package timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import timesheet.dto.EmployeDto;
import timesheet.service.EmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employe/")
public class EmployeController {

    private EmployeService service;

    @Autowired
    public EmployeController(EmployeService service) {
        this.service = service;
    }

    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    public List<EmployeDto> getAll() {
        return service.getAll();
    }

}
