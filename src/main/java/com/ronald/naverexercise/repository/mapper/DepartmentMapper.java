package com.ronald.naverexercise.repository.mapper;

import com.ronald.naverexercise.entity.Department;
import com.ronald.naverexercise.payload.dto.department.DepartmentDto;
import com.ronald.naverexercise.payload.dto.department.DepartmentWithNumEmpDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import static com.ronald.naverexercise.repository.mapper.queries.DepartmentQueries.*;

@Mapper
public interface DepartmentMapper {

    @Select(GET_DEPARTMENT_WITH_NUMS_EMPLOYEES_BY_ID)
    @Results(value = { @Result(property = "departmentId", column = "department_id"),
            @Result(property = "departmentName", column = "department_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "numEmployees", column = "sum")}
    )
    DepartmentWithNumEmpDto getDepartmentWithNumEmpls(Long id);

    @Select(GET_DEPARTMENT_BY_ID)
    @Results(value = { @Result(property = "departmentId", column = "department_id"),
            @Result(property = "departmentName", column = "department_name"),
            @Result(property = "description", column = "description")}
    )
    Department findDepartmentById(Long id);

}
