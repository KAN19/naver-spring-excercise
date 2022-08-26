package com.ronald.naverexercise.repository.mapper;

import com.ronald.naverexercise.entity.Department;
import com.ronald.naverexercise.entity.Employee;
import com.ronald.naverexercise.payload.dto.department.DepartmentDto;
import com.ronald.naverexercise.payload.dto.employee.EmployeeWithDepartmentDto;
import org.apache.ibatis.annotations.*;

import static com.ronald.naverexercise.repository.mapper.queries.DepartmentQueries.*;
import static com.ronald.naverexercise.repository.mapper.queries.EmployeeQueries.*;

@Mapper
public interface EmployeeMapper {

    @Select(GET_EMPLOYEE_BY_ID)
    @Results(value = { @Result(property = "employeeId", column = "employee_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "birthDate", column = "birth_date"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "department", column = "department_id",
                    one = @One(select="com.ronald.naverexercise.repository.mapper.DepartmentMapper.findDepartmentById") ),
           }
    )
    EmployeeWithDepartmentDto getEmployeeWithDepartmentObjectsById(Long id);


}
