package timesheet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import timesheet.dao.entity.ProjectReportEntity;
import timesheet.dao.entity.TimesheetEntity;
import timesheet.dao.entity.VTimesheetInfoEntity;
import timesheet.dao.repository.ProjectReportRepository;
import timesheet.dao.repository.TimesheetRepository;
import timesheet.dao.repository.VTimesheetInfoRepository;
import timesheet.dto.FilterDto;
import timesheet.dto.timesheet.FilterReportDto;
import timesheet.dto.timesheet.ReportDto;
import timesheet.dto.timesheet.TimesheetInfoDto;
import timesheet.exceptions.UserException;
import timesheet.utils.ProjectConst;

import java.math.MathContext;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimesheetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimesheetService.class);

    private VTimesheetInfoRepository timesheetInfoRepository;

    private TimesheetRepository timesheetRepository;

    private ProjectReportRepository projectReportRepository;

    @Autowired
    public TimesheetService(VTimesheetInfoRepository timesheetInfoRepository, TimesheetRepository timesheetRepository,
                            ProjectReportRepository projectReportRepository) {
        this.timesheetInfoRepository = timesheetInfoRepository;
        this.timesheetRepository = timesheetRepository;
        this.projectReportRepository = projectReportRepository;
    }

    public List<TimesheetInfoDto> getTimesheetList(FilterDto filterDto) {

        List<VTimesheetInfoEntity> timesheetInfoEntityList;

        Pageable page = PageRequest.of(filterDto.getPage() - 1, 25, Sort.by("createTime").descending());

        if (filterDto.getUserId() != null && filterDto.getUserId() > 0) {
            timesheetInfoEntityList = timesheetInfoRepository.getByEmployeIdOrderByCreateTimeDesc(filterDto.getUserId(), page);
        } else {
            timesheetInfoEntityList = timesheetInfoRepository.findAll(page);
        }


        List<TimesheetInfoDto> timesheetInfoDtoList = new ArrayList<>();

        for (VTimesheetInfoEntity entity : timesheetInfoEntityList) {
            timesheetInfoDtoList.add(new TimesheetInfoDto(entity));
        }

        return timesheetInfoDtoList;
    }

    private void mapDtoToEntity (TimesheetInfoDto timesheetDto, TimesheetEntity entity) {
        entity.setTaskDescription(timesheetDto.getTaskDescription());
        entity.setTaskNum(timesheetDto.getTaskNum());
        entity.setWorkDate(Timestamp.from(timesheetDto.getWorkDate().toInstant()));
        entity.setEmployeId(timesheetDto.getEmployeId());
        entity.setProjectId(timesheetDto.getProjectId());
        entity.setTimeWasted(timesheetDto.getTimeWasted()
                .multiply(ProjectConst.MINUTES_IN_HOUR)
                .round(MathContext.UNLIMITED)
                .longValue());
    }

    public TimesheetInfoDto updateTimesheet(TimesheetInfoDto timesheetDto) {
        TimesheetEntity entity = timesheetRepository.getOne(timesheetDto.getId());

        if (entity == null) {
            LOGGER.error("Запись не найдена в БД.");
            throw new UserException("Запись не найдена в БД.");
        }

        mapDtoToEntity(timesheetDto, entity);

        timesheetRepository.save(entity);

        return timesheetDto;
    }

    @Transactional
    public TimesheetInfoDto createTimesheet(TimesheetInfoDto timesheetDto) {

        if (timesheetDto.getEmployeId() == null || timesheetDto.getProjectId() == null
                || timesheetDto.getWorkDate() == null || timesheetDto.getTaskNum() == null) {
            throw new UserException("Необходимо заполнить обязательные поля");
        }

        if (timesheetDto.getId() != null && timesheetDto.getId() > 0) {
            return updateTimesheet(timesheetDto);
        }

        TimesheetEntity entity = new TimesheetEntity();

        mapDtoToEntity(timesheetDto, entity);
        entity.setCreateTime(Timestamp.from(Instant.now()));

        entity = timesheetRepository.save(entity);
        VTimesheetInfoEntity timesheetInfoEntity = timesheetInfoRepository.getById(entity.getId());

        return new TimesheetInfoDto(timesheetInfoEntity);
    }

    public List<ReportDto> getCommonReport(FilterReportDto filter) {

        Timestamp start = (filter.getStart() != null)
                ? Timestamp.from(filter.getStart().toInstant()) : Timestamp.from(Instant.ofEpochMilli(0));

        Timestamp end = (filter.getEnd() != null)
                ? Timestamp.from(filter.getEnd().toInstant()) : Timestamp.from(Instant.now());

        List<ProjectReportEntity> projectReportEntitieList = projectReportRepository.getReportByInterval(start, end);
        List<ReportDto> reportDtoList = new ArrayList<>();

        for (ProjectReportEntity entity : projectReportEntitieList) {
            reportDtoList.add(new ReportDto(entity));
        }

        return reportDtoList;
    }
}
