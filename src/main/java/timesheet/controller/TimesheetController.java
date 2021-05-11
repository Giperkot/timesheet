package timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import timesheet.dto.timesheet.TimesheetInfoDto;
import timesheet.service.TimesheetService;

import java.util.List;

@RestController
@RequestMapping("api/timesheet/")
public class TimesheetController {

    private TimesheetService timesheetService;

    @Autowired
    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    public List<TimesheetInfoDto> getTimesheetList() {
        return timesheetService.getTimesheetList();
    }

    /*@RequestMapping(value = "getCommonReport", method = RequestMethod.POST)
    public List<TimesheetInfoDto> getCommonReport() {
        return timesheetService.getCommonReport();
    }

    @RequestMapping(value = "getTimesheet", method = RequestMethod.GET)
    public TimesheetInfoDto getTimesheet(@RequestParam Long id) {
        return timesheetService.getTimesheet();
    }

    @RequestMapping(value = "createTimesheet", method = RequestMethod.POST)
    public TimesheetInfoDto createTimesheet(TimesheetDto timesheetDto) {
        return timesheetService.createTimesheet();
    }

    @RequestMapping(value = "createTimesheet", method = RequestMethod.PUT)
    public TimesheetInfoDto updateTimesheet(TimesheetDto timesheetDto) {
        return timesheetService.createTimesheet();
    }*/

}
