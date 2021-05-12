package timesheet.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import timesheet.dao.entity.ProjectEntity;

import java.util.List;

public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

    @Query(value = "select * from project order by name", nativeQuery = true)
    List<ProjectEntity> getAll();

}
