package servicesImpl;

import org.springframework.stereotype.Service;
import dto.DepartmentDto;
import entities.Department;
import lombok.AllArgsConstructor;
import repositories.DepartmentRepository;
import services.DepartmentService;

 

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

 

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

 

        // convert department dto to department jpa entity
        Department department = new Department(departmentDto.getId(), departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode());
        Department savedDepartment = departmentRepository.save(department);


        DepartmentDto savedDepartmentDto = new DepartmentDto(savedDepartment.getId(), 
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(), 
                savedDepartment.getDepartmentCode());
        return savedDepartmentDto;
    }

 

}
