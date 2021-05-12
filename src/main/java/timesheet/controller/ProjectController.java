package timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import timesheet.dto.ProjectDto;
import timesheet.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/project/")
public class ProjectController {

    private ProjectService service;

    @Autowired
    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    public List<ProjectDto> getAll() {
        return service.getAll();
    }

}
