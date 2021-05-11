package timesheet.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import timesheet.dao.entity.VTimesheetInfoEntity;

import java.util.List;

public interface VTimesheetInfoRepository extends CrudRepository<VTimesheetInfoEntity, Long> {

    @Query(value = "select * from v_timesheet_info order by create_time desc", nativeQuery = true)
    List<VTimesheetInfoEntity> getAllorderByCreateTime();

}
