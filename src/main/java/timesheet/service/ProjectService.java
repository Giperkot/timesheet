package timesheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.dao.entity.ProjectEntity;
import timesheet.dao.repository.ProjectRepository;
import timesheet.dto.ProjectDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectDto> getAll() {
        List<ProjectEntity> employeEntityList = projectRepository.getAll();

        List<ProjectDto> projectDtoList = new ArrayList<>();

        for (ProjectEntity entity : employeEntityList) {
            projectDtoList.add(new ProjectDto(entity));
        }

        return projectDtoList;
    }

}
