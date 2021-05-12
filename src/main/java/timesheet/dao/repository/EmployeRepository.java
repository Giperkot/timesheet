package timesheet.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import timesheet.dao.entity.EmployeEntity;

import java.util.List;

public interface EmployeRepository extends CrudRepository<EmployeEntity, Long> {

    @Query(value = "select * from employe order by last_name, first_name", nativeQuery = true)
    List<EmployeEntity> getAll();

}
