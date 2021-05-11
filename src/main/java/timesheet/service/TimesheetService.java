package timesheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.dao.entity.VTimesheetInfoEntity;
import timesheet.dao.repository.VTimesheetInfoRepository;
import timesheet.dto.timesheet.TimesheetInfoDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimesheetService {

    private VTimesheetInfoRepository timesheetInfoRepository;

    @Autowired
    public TimesheetService(VTimesheetInfoRepository timesheetInfoRepository) {
        this.timesheetInfoRepository = timesheetInfoRepository;
    }

    // todo Добавить пагинацию
    public List<TimesheetInfoDto> getTimesheetList() {

        List<VTimesheetInfoEntity> timesheetInfoEntityList = timesheetInfoRepository.getAllorderByCreateTime();

        List<TimesheetInfoDto> timesheetInfoDtoList = new ArrayList<>();

        for (VTimesheetInfoEntity entity : timesheetInfoEntityList) {
            timesheetInfoDtoList.add(new TimesheetInfoDto(entity));
        }

        return timesheetInfoDtoList;
    }

}
