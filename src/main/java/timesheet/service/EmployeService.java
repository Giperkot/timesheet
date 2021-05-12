package timesheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timesheet.dao.entity.EmployeEntity;
import timesheet.dao.repository.EmployeRepository;
import timesheet.dto.EmployeDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeService {

    private EmployeRepository employeRepository;

    @Autowired
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public List<EmployeDto> getAll() {
        List<EmployeEntity> employeEntityList = employeRepository.getAll();

        List<EmployeDto> employeDtoList = new ArrayList<>();

        for (EmployeEntity entity : employeEntityList) {
            employeDtoList.add(new EmployeDto(entity));
        }

        return employeDtoList;
    }

}
