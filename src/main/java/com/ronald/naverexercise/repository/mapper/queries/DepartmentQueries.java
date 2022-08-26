package com.ronald.naverexercise.repository.mapper.queries;

public final class DepartmentQueries {
    public static final String GET_DEPARTMENT_WITH_NUMS_EMPLOYEES_BY_ID
            = "SELECT DEPARTMENT.department_id, department_name, description, count( EMPLOYEE.employee_id) as sum " +
            "FROM DEPARTMENT LEFT JOIN EMPLOYEE ON DEPARTMENT.department_id = EMPLOYEE.department_id " +
            "WHERE DEPARTMENT.department_id = #{id}" +
            "GROUP BY DEPARTMENT.department_id";

    public static final String GET_DEPARTMENT_BY_ID
            = "SELECT * FROM DEPARTMENT " +
            "WHERE department_id = #{id}";
}
