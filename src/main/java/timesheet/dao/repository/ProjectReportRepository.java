package timesheet.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import timesheet.dao.entity.ProjectReportEntity;

import java.sql.Timestamp;
import java.util.List;

public interface ProjectReportRepository extends CrudRepository<ProjectReportEntity, Long> {

    @Query(value = "select " +
            "   t1.project_id, " +
            "   t1.sum_time_wasted, " +
            "   t1.employe_count," +
            "   p.name as project_name " +
            " from (select t.project_id,\n" +
            "           sum(time_wasted)  as sum_time_wasted,\n" +
            "           count(employe_id) as employe_count\n" +
            "    from timesheet t\n" +
            "    where t.work_date between ? and ? \n" +
            "    group by project_id) t1 " +
            " join project p on p.id = t1.project_id", nativeQuery = true)
    List<ProjectReportEntity> getReportByInterval(Timestamp dateStart, Timestamp dateEnd);

}
