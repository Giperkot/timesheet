package timesheet.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timesheet.dao.entity.TimesheetEntity;

public interface TimesheetRepository extends JpaRepository<TimesheetEntity, Long> {



}
