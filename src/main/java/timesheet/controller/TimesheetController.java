package timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import timesheet.dto.FilterDto;
import timesheet.dto.timesheet.FilterReportDto;
import timesheet.dto.timesheet.ReportDto;
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
    public List<TimesheetInfoDto> getTimesheetList(@RequestBody FilterDto filterDto) {
        return timesheetService.getTimesheetList(filterDto);
    }

    @RequestMapping(value = "getCommonReport", method = RequestMethod.POST)
    public List<ReportDto> getCommonReport(@RequestBody FilterReportDto filter) {
        return timesheetService.getCommonReport(filter);
    }

    /*@RequestMapping(value = "getTimesheet", method = RequestMethod.GET)
    public TimesheetInfoDto getTimesheet(@RequestParam Long id) {
        return timesheetService.getTimesheet();
    }*/

    @RequestMapping(value = "createTimesheet", method = RequestMethod.POST)
    public TimesheetInfoDto createTimesheet(@RequestBody TimesheetInfoDto timesheetDto) {
        return timesheetService.createTimesheet(timesheetDto);
    }

    @RequestMapping(value = "updateTimesheet", method = RequestMethod.PUT)
    public TimesheetInfoDto updateTimesheet(@RequestBody TimesheetInfoDto timesheetDto) {
        return timesheetService.createTimesheet(timesheetDto);
    }

}
